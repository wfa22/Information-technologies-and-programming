import java.util.*;

public class Shop {
    private final LinkedList<Sale> sales = new LinkedList<>();

    private static class Sale {
        private final String product;
        private final double price;

        public Sale(String product, double price) {
            this.product = product;
            this.price = price;
        }

        public String getProduct() {
            return product;
        }

        public double getPrice() {
            return price;
        }
    }

    public void addSale(String product, double price) {
        sales.add(new Sale(product, price));
    }

    public void showSales() {
        if (sales.isEmpty()) {
            System.out.println("Проданных товаров нет.");
        } else {
            System.out.println("Список проданных товаров:");
            for (Sale sale : sales) {
                System.out.println("Товар: " + sale.getProduct() + ", Цена: " + sale.getPrice());
            }
        }
    }

    public double totalSalesAmount() {
        return sales.stream()
                .mapToDouble(Sale::getPrice)
                .sum();
    }

    public List<String> getMostPopularProducts() {
        if (sales.isEmpty()) {
            return List.of("Нет продаж");
        }

        Map<String, Double> productRevenue = new HashMap<>();
        for (Sale sale : sales) {
            productRevenue.put(sale.getProduct(),
                    productRevenue.getOrDefault(sale.getProduct(), 0.0) + sale.getPrice());
        }

        double maxRevenue = productRevenue.values().stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(0.0);

        return productRevenue.entrySet().stream()
                .filter(entry -> entry.getValue() == maxRevenue)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addSale("Яблоки", 100.0);
        shop.addSale("Апельсины", 80.0);
        shop.addSale("Яблоки", 100.0);
        shop.addSale("Бананы", 70.0);
        shop.addSale("Апельсины", 120.0);

        shop.showSales();

        System.out.println("Общая сумма продаж: " + shop.totalSalesAmount() + " руб.");
        List<String> popularProducts = shop.getMostPopularProducts();
        System.out.println("Самые популярные товары: " + String.join(", ", popularProducts));
    }
}
