import java.util.HashMap;

public class OnlinStore {
    private HashMap<String, Product> products = new HashMap<>();

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
        OnlinStore store = new OnlinStore();

        store.addProduct("A100", new Product("Laptop", "Gaming laptop", 1200.99, 10));
        store.addProduct("B200", new Product("Phone", "Smartphone", 799.99, 25));
        store.addProduct("C300", new Product("Tablet", "Android tablet", 499.99, 15));
        store.addProduct("D400", new Product("Monitor", "4K Monitor", 299.99, 20));
        store.addProduct("E500", new Product("Headphones", "Wireless headphones", 99.99, 50));

        System.out.println("Количество элементов в таблице: " + store.products.size());
        System.out.println(store.findProduct("A100"));
        store.removeProduct("B200");
        System.out.println("Количество элементов в таблице после удаления: " + store.products.size());

        System.out.println("Продукты в магазине:");
        for (String key : store.products.keySet()) {
            System.out.println(key + " -> " + store.products.get(key));
        }
    }
}
