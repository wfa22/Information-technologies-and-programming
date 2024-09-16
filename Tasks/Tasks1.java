public class Tasks1 {
    public static void main(String[] args) {
        System.out.println("==================");
        System.out.println(task1(5));
        System.out.println(task1(3));
        System.out.println(task1(8));
        System.out.println("==================");
        System.out.println(task2(15, 1));
        System.out.println(task2(24, 2));
        System.out.println(task2(41, 3));
        System.out.println("==================");
        System.out.println(task3(3, 4, 2));
        System.out.println(task3(5, 0, 2));
        System.out.println(task3(4, 1, 4));
        System.out.println("==================");
        System.out.println(task4(5, 5, 5));
        System.out.println(task4(5, 4, 5));
        System.out.println(task4(3, 4, 5));
        System.out.println(task4(5, 1, 1));
        System.out.println("==================");
        System.out.println(task5(8, 4));
        System.out.println(task5(1, 11));
        System.out.println(task5(5, 9));
        System.out.println("==================");
        System.out.println(task6(22, 1.4, 2));
        System.out.println(task6(45, 1.8, 2.9));
        System.out.println(task6(100, 2, 2));
        System.out.println("==================");
        System.out.println(task7(3));
        System.out.println(task7(5));
        System.out.println(task7(7));
        System.out.println("==================");
        System.out.println(task8(48, 18));
        System.out.println(task8(52, 8));
        System.out.println(task8(259, 28));
        System.out.println("==================");
        System.out.println(task9(70, 1500));
        System.out.println(task9(24, 950));
        System.out.println(task9(53, 1250));
        System.out.println("=================");
        System.out.println(task10(5, 2));
        System.out.println(task10(31, 20));
        System.out.println(task10(123, 58));

    }

    public static float task1(int n) {
        return (float) (n * 3.785);
    }

    public static int task2(int n, int m) {
        return (n * m);
    }

    public static float task3(int n, int m, int l) {
        return (int) (n * 20 + m * 50 + l * 100);
    }

    public static String task4(int x, int y, int z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "не является треугольником";
        }
        if (x == y && y == z) {
            return "равносторонний";
        } else if (x == y || y == z || x == z) {
            return "равнобедренный";
        } else {
            return "разносторонний";
        }
    }

    public static int task5(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int task6(double a, double b, double c) {
        return (int) (((a / 2) / b) / c);
    }

    public static int task7(int n) {
        int res = 1;
        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static int task8(int a, int b) {
        int res = 1;
        for (int i = 1; i <= a; i++) {
            if (b % i == 0) {
                if (a % i == 0) {
                    res = i;
                }
            }
        }
        return res;
    }

    public static int task9(double a, double b) {
        return (int) (a * b * 0.72);
    }

    public static int task10(int a, int b) {
        int need = ((a + 1) / 2);
        return (need > b) ? (need - b) : 0;
    }
}