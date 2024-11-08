import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "123fsaf12sad";

        if (password == null || password.isEmpty()) {
            System.out.println("Пароль не может быть пустым.");
            return;
        }

        try {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Пароль корректен!");
            } else {
                System.out.println("Пароль некорректен! Он должен содержать от 8 до 16 символов, хотя бы одну заглавную букву и одну цифру.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
        }
    }
}
