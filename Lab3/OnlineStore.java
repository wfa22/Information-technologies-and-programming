public class OnlineStore {
    private HashTable<String, Product> products = new HashTable<>(3);

    public void addProduct(String article, Product product) {
        products.put(article, product);
    }

    public Product findProduct(String article) {
        return products.get(article);
    }

    public void removeProduct(String article) {
        products.remove(article);
    }

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        System.out.println("Размер таблицы: " + store.products.length());
        store.addProduct("A100", new Product("Laptop", "Gaming laptop", 1200.99, 10));
        store.addProduct("B200", new Product("Phone", "Smartphone", 799.99, 25));
        store.addProduct("C300", new Product("Tablet", "Android tablet", 499.99, 15));
        store.addProduct("D400", new Product("Monitor", "4K Monitor", 299.99, 20));
        store.addProduct("E500", new Product("Headphones", "Wireless headphones", 99.99, 50));

        System.out.println("Размер таблицы: " + store.products.length());
        System.out.println("Количество элементов в таблице: " + store.products.size());
        System.out.println(store.findProduct("A100"));
        store.removeProduct("B200");
        System.out.println("Количество элементов в таблице: " + store.products.size());
        store.products.printEntriesAtIndex(0);
        store.products.printEntriesAtIndex(1);
        store.products.printEntriesAtIndex(2);
        store.products.printEntriesAtIndex(3);
        store.products.printEntriesAtIndex(4);
        store.products.printEntriesAtIndex(5);
    }
}

class Product {
    private String name;
    private String description;
    private double price;
    private int stock;

    public Product(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", price=" + price + ", stock=" + stock + '}';
    }
}


