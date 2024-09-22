import java.util.Arrays;

public class Tasks2 {
    public static void main(String[] args) {
        System.out.println("==================");
        System.out.println(duplicateChars("Barack", "Obama")); // "rck"
        System.out.println(duplicateChars("Hello", "World")); // "He"
        System.out.println("==================");
        System.out.println(dividedByThree(new int[]{3, 12, 7, 81, 52})); // 2
        System.out.println(dividedByThree(new int[]{9, 27, 4, 10})); // 2
        System.out.println("==================");
        System.out.println(getInitials("simonov sergei evgenievich")); // "S.E.Simonov"
        System.out.println(getInitials("kozhevnikova tatiana vitalevna")); // "T.V.Kozhevnikova"
        System.out.println("==================");
        System.out.println(Arrays.toString(normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5}))); // [0.2666, 0.7333, 0.0, 1.0, 0.5333]
        System.out.println(Arrays.toString(normalizator(new double[]{10.0, 10.0, 10.0, 10.0}))); // [0.0, 0.0, 0.0, 0.0]
        System.out.println("==================");
        System.out.println(Arrays.toString(compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5}))); // [1, 27, 34, 212]
        System.out.println(Arrays.toString(compressedNums(new double[]{0, 0, 0, 5}))); // [5]
        System.out.println("==================");
        System.out.println(camelToSnake("helloWorld")); // "hello_world"
        System.out.println(camelToSnake("myVariableName")); // "my_variable_name"
        System.out.println("==================");
        System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4})); // 5
        System.out.println(secondBiggest(new int[]{10, 20, 30, 40})); // 30
        System.out.println("==================");
        System.out.println(localReverse("baobab", 'b')); // "baboab"
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e')); // " Hednu m’I ,oller thetaw er, plesae hem ple"
        System.out.println("==================");
        System.out.println(equal(8, 1, 8)); // 2
        System.out.println(equal(5, 5, 5)); // 3
        System.out.println(equal(4, 9, 6)); // 0
        System.out.println("==================");
        System.out.println(isAnagram("LISTEN", "silent")); // true
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!")); // true
        System.out.println(isAnagram("hello", "world")); // false
    }

    public static String duplicateChars(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        for (char c : str1.toCharArray()) {
            if (!str2.contains(String.valueOf(c))) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static int dividedByThree(int[] arr) {
        int cnt = 0;
        for (int n : arr) {
            if (n % 2 != 0 && n % 3 == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static String getInitials(String name) {
        String[] words = name.split(" ");
        String inits = Character.toUpperCase(words[1].charAt(0)) + "." + Character.toUpperCase(words[2].charAt(0)) + ".";
        return inits + Character.toUpperCase(words[0].charAt(0)) + words[0].substring(1);
    }

    public static double[] normalizator(double[] arr) {
        double min = Arrays.stream(arr).min().getAsDouble();
        double max = Arrays.stream(arr).max().getAsDouble();

        if (min == max) {
            return new double[arr.length];
        }
        double[] normalized = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            normalized[i] = ((arr[i] - min) / (max - min));
        }
        return normalized;
    }

    public static int[] compressedNums(double[] arr) {
        return Arrays.stream(arr).filter(n -> n != 0).mapToInt(n -> (int) Math.floor(n)).distinct().sorted().toArray();
    }

    public static String camelToSnake(String str) {
        return str.replaceAll("([A-Z])", "_$1").toLowerCase();
    }

    public static int secondBiggest(int[] arr) {
        int maxim = Arrays.stream(arr).max().getAsInt();
        return (int) Arrays.stream(arr).filter(n -> n != maxim).max().getAsInt();
    }

    public static String localReverse(String str, char marker) {
        int start = str.indexOf(marker);
        int end = str.lastIndexOf(marker);
        if (start == -1 || start == end) return str;
        String middle = new StringBuilder(str.substring(start + 1, end)).reverse().toString();
        return str.substring(0, start + 1) + middle + str.substring(end);
    }

    public static int equal(int a, int b, int c) {
        if (a == b && b == c) return 3;
        if (a == b || b == c || a == c) return 2;
        return 0;
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
        char[] arr2 = str2.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
