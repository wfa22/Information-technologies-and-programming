public class ArrayAverage {
    public static void main(String[] args) {
        Object[] arr = {1, 2, 3, 4, 5};
        int sum = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                    sum += (int) arr[i]; }

            double average =  sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за пределы массива. " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль! " + e.getMessage());
        } catch (ClassCastException e) {
            System.out.println("Неверный тип данных");
        } catch (Exception e) {
            System.out.println("Общая ошибка: " + e.getMessage());
        }

    }
}