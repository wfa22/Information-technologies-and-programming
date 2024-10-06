public class OnlineStore {
    private HashTable<String, Product> products = new HashTable<>(10);

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
        store.addProduct("A100", new Product("Laptop", "Gaming laptop", 1200.99, 10));
        store.addProduct("B200", new Product("Phone", "Smartphone", 799.99, 25));

        System.out.println(store.products.size());
        System.out.println(store.findProduct("A100"));
        store.removeProduct("B200");
        System.out.println(store.products.size());
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


