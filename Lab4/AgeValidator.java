import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AgeValidator {

    public static void validateAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Недопустимый возраст: " + age);
        } else {
            System.out.println("Возраст " + age + " является допустимым.");
        }
    }

    public static void logException(Exception e) {
        try (FileWriter fw = new FileWriter("exceptions_log.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Исключение: " + e.getClass().getName());
            pw.println("Сообщение: " + e.getMessage());
            pw.println("Стек вызовов:");
            e.printStackTrace(pw);
            pw.println("===================================");
        } catch (IOException ioEx) {
            System.err.println("Ошибка записи в лог-файл: " + ioEx.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(25);
            validateAge(-5);
        } catch (CustomAgeException e) {
            System.out.println(e.getMessage());
            logException(e);
        }

        try {
            validateAge(150);
        } catch (CustomAgeException e) {
            System.out.println(e.getMessage());
            logException(e);
        }
    }
}
