import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tasks3 {
    public static void main(String[] args) {
        System.out.println("==================");
        System.out.println(isStrangePair("ratio", "orator")); // true
        System.out.println(isStrangePair("sparkling", "groups")); // true
        System.out.println(isStrangePair("bush", "hubris")); // false
        System.out.println(isStrangePair("", "")); // true
        System.out.println("==================");
        System.out.println(Arrays.deepToString(sale(new String[][]{{"Laptop", "124200"}, {"Phone", "51450"}, {"Headphones", "13800"}}, 25)));
        System.out.println("==================");
        System.out.println(successShoot(0, 0, 5, 2, 2)); // true
        System.out.println(successShoot(-2, -3, 4, 5, -6)); // false
        System.out.println("==================");
        System.out.println(parityAnalysis(243)); // true
        System.out.println(parityAnalysis(12)); // false
        System.out.println(parityAnalysis(3)); // true
        System.out.println("==================");
        System.out.println(rps("rock", "paper")); // Player 2 wins
        System.out.println(rps("scissors", "scissors")); // Tie
        System.out.println("==================");
        System.out.println(bugger(39)); // 3
        System.out.println(bugger(999)); // 4
        System.out.println(bugger(4)); // 0
        System.out.println("==================");
        System.out.println(mostExpensive(new String[][]{{"Скакалка", "550", "8"}, {"Шлем", "3750", "4"}, {"Мяч", "2900", "10"}})); // "Мяч - 29000"
        System.out.println("==================");
        System.out.println(longestUnique("abcba")); // abc
        System.out.println(longestUnique("bbb")); // b
        System.out.println("==================");
        System.out.println(isPrefix("automation", "auto-")); // true
        System.out.println(isSuffix("arachnophobia", "-phobia")); // true
        System.out.println("==================");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1)); // true
        System.out.println(doesBrickFit(1, 2, 2, 1, 1)); // false
    }

    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) return true;
        if (str1.isEmpty() || str2.isEmpty()) return false;
        return str1.charAt(0) == str2.charAt(str2.length() - 1) &&
                str1.charAt(str1.length() - 1) == str2.charAt(0);
    }

    public static String[][] sale(String[][] items, int discount) {
        for (String[] item : items) {
            int price = Integer.parseInt(item[1]);
            int discountedPrice = (int) Math.max(1, Math.round(price * (1 - discount / 100.0)));
            item[1] = String.valueOf(discountedPrice);
        }
        return items;
    }

    public static boolean successShoot(int x, int y, int r, int m, int n) {
        return Math.sqrt(Math.pow(m - x, 2) + Math.pow(n - y, 2)) <= r;
    }

    public static boolean parityAnalysis(int num) {
        int sum = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).sum();
        return (num % 2 == sum % 2);
    }

    public static String rps(String p1, String p2) {
        if (p1.equals(p2)) return "Tie";
        if ((p1.equals("rock") && p2.equals("scissors")) ||
                (p1.equals("scissors") && p2.equals("paper")) ||
                (p1.equals("paper") && p2.equals("rock"))) {
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }

    public static int bugger(int num) {
        int count = 0;
        while (num >= 10) {
            num = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b);
            count++;
        }
        return count;
    }

    public static String mostExpensive(String[][] inventory) {
        String mostExpensiveItem = "";
        int maxTotalPrice = 0;
        for (String[] item : inventory) {
            int price = Integer.parseInt(item[1]);
            int quantity = Integer.parseInt(item[2]);
            int totalPrice = price * quantity;
            if (totalPrice > maxTotalPrice) {
                maxTotalPrice = totalPrice;
                mostExpensiveItem = item[0];
            }
        }
        return "Наиб. общ. стоимость у предмета " + mostExpensiveItem + " - " + maxTotalPrice;
    }

    public static String longestUnique(String str) {
        String longest = "";
        String current = "";
        for (char c : str.toCharArray()) {
            if (current.contains(String.valueOf(c))) {
                current = current.substring(current.indexOf(c) + 1);
            }
            current += c;
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        return longest;
    }

    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w);
    }
}
