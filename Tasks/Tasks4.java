import java.util.*;
import java.util.stream.Collectors;

public class Tasks4 {

    public static void main(String[] args) {
        System.out.println("======= Task 1 =======");
        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));

        System.out.println("======= Task 2 =======");
        System.out.println(bruteForce(1, 5));
        System.out.println(bruteForce(2, 2));
        System.out.println(bruteForce(5, 3));

        System.out.println("======= Task 3 =======");
        System.out.println(Arrays.toString(decode("MTUCI", "MKIIT")));
        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT"));

        System.out.println("======= Task 4 =======");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));

        System.out.println("======= Task 5 =======");
        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));

        System.out.println("======= Task 6 =======");
        System.out.println(convertToRome(8));
        System.out.println(convertToRome(1234));
        System.out.println(convertToRome(52));

        System.out.println("======= Task 7 =======");
        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("12223234333"));

        System.out.println("======= Task 8 =======");
        System.out.println(labirint(new int[][]{{1, 3, 1}, {1, -1, 1}, {4, 2, 1}}));
        System.out.println(labirint(new int[][]{{2, -7, 3}, {-4, -1, 8}, {4, 5, 9}}));

        System.out.println("======= Task 9 =======");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("======= Task 10 =======");
        System.out.println(fibString("CCCABDD"));
        System.out.println(fibString("ABC"));
    }

    public static String nonRepeat(String str) {
        str = str.toLowerCase();
        Map<Character, Long> freqMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (freqMap.get(c) <= 3) {
                result.append(c);
            }
        }

        String resultStr = result.toString();
        if (resultStr.equals(str)) return resultStr;

        return nonRepeat(resultStr);
    }

    public static List<String> bruteForce(int n, int k) {
        if (k > 5) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        generateCombinations("", n, k, result);
        return result;
    }

    private static void generateCombinations(String prefix, int n, int k, List<String> result) {
        if (prefix.length() == n) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!prefix.contains(String.valueOf(i))) {
                generateCombinations(prefix + i, n, k, result);
            }
        }
    }

    public static int[] decode(String text, String key) {
        int[] result = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i) ^ key.charAt(i % key.length());
        }
        return result;
    }

    public static String encode(int[] data, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            result.append((char) (data[i] ^ key.charAt(i % key.length())));
        }
        return result.toString();
    }

    public static List<String> split(String s) {
        List<String> result = new ArrayList<>();
        int balance = 0;
        StringBuilder cluster = new StringBuilder();
        for (char ch : s.toCharArray()) {
            cluster.append(ch);
            balance += (ch == '(') ? 1 : -1;
            if (balance == 0) {
                result.add(cluster.toString());
                cluster.setLength(0);
            }
        }
        return result;
    }

    public static String shortHand(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(str.charAt(i));
            if (count > 1) result.append('*').append(count);
        }
        return result.toString();
    }

    public static String convertToRome(int num) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                result.append(romanNumerals[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    public static String uniqueSubstring(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            countMap.put(str.charAt(i), countMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        int maxCount = Collections.max(countMap.values());
        boolean isEven = str.indexOf(countMap.entrySet().stream().filter(e -> e.getValue() == maxCount).findFirst().get().getKey()) % 2 == 0;
        return isEven ? "чет" : "нечет";
    }

    public static List<String> labirint(int[][] grid) {
        int n = grid.length;
        List<int[]> path = new ArrayList<>();
        if (findPath(grid, n - 1, n - 1, path)) {
            return List.of(
                    path.stream().map(cell -> String.valueOf(grid[cell[0]][cell[1]])).collect(Collectors.joining("-")),
                    String.valueOf(path.stream().mapToInt(cell -> grid[cell[0]][cell[1]]).sum())
            );
        }
        return List.of("Прохода нет");
    }

    private static boolean findPath(int[][] grid, int x, int y, List<int[]> path) {
        if (x < 0 || y < 0 || grid[x][y] < 0) return false;
        path.add(new int[]{x, y});

        if (x == 0 && y == 0) return true;

        if (findPath(grid, x - 1, y, path) || findPath(grid, x, y - 1, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static String numericOrder(String sentence) {
        String[] words = sentence.split(" ");
        return Arrays.stream(words)
                .sorted(Comparator.comparingInt(w -> Integer.parseInt(w.replaceAll("\\D", ""))))
                .map(w -> w.replaceAll("\\d", ""))
                .collect(Collectors.joining(" "));
    }

    public static boolean fibString(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : str.toCharArray()) countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts);
        return isFibonacciSequence(counts);
    }

    private static boolean isFibonacciSequence(List<Integer> counts) {
        if (counts.size() < 3) return false;
        for (int i = 2; i < counts.size(); i++) {
            if (counts.get(i) != counts.get(i - 1) + counts.get(i - 2)) return false;
        }
        return true;
    }
}
