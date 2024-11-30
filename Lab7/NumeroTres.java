import java.util.*;

public class NumeroTres {

    public static class Item {
        private final String name;
        private final int weight;

        public Item(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return name + " (" + weight + " kg)";
        }
    }

    public static class Storage {
        private final Queue<Item> items = new LinkedList<>();

        public synchronized void addItem(Item item) {
            items.add(item);
        }

        public synchronized Item getNextItem() {
            return items.poll();
        }

        public synchronized boolean isEmpty() {
            return items.isEmpty();
        }
    }

    public static class Worker extends Thread {
        private final Storage storage;
        private final List<Item> sharedLoad;
        private final int workerId;
        private static final int MAX_LOAD = 150;
        private static int totalWeight = 0;

        public Worker(Storage storage, List<Item> sharedLoad, int workerId) {
            this.storage = storage;
            this.sharedLoad = sharedLoad;
            this.workerId = workerId;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (sharedLoad) {
                    if (storage.isEmpty() && sharedLoad.isEmpty()) {
                        sharedLoad.notifyAll();
                        System.out.println("Worker " + workerId + " has finished work.");
                        break;
                    }

                    if (totalWeight > 0 && (totalWeight+storage.getNextItem().getWeight() > MAX_LOAD || (storage.isEmpty() && !sharedLoad.isEmpty()))) {
                        System.out.println("Worker " + workerId + " is helping transport items: " + sharedLoad +
                                ". Total weight: " + totalWeight + " kg.");
                        sharedLoad.clear();
                        totalWeight = 0;

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }

                        System.out.println("Worker " + workerId + " has delivered the items.");
                        sharedLoad.notifyAll();
                        continue;
                    }

                    if (!storage.isEmpty() && totalWeight < MAX_LOAD) {
                        Item item = storage.getNextItem();
                        if (item != null && totalWeight + item.getWeight() <= MAX_LOAD) {
                            sharedLoad.add(item);
                            totalWeight += item.getWeight();
                            System.out.println("Worker " + workerId + " added " + item + " to the shared load.");
                            sharedLoad.notifyAll();
                        }
                    }

                    try {
                        sharedLoad.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        Random random = new Random();

        for (int i = 1; i <= 30; i++) {
            storage.addItem(new Item("Item" + i, random.nextInt(30) + 10)); // Вес от 10 до 40 кг
        }

        List<Item> sharedLoad = Collections.synchronizedList(new ArrayList<>());

        Worker worker1 = new Worker(storage, sharedLoad, 1);
        Worker worker2 = new Worker(storage, sharedLoad, 2);
        Worker worker3 = new Worker(storage, sharedLoad, 3);

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All items have been transported.");
    }
}
