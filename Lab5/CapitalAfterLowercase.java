import java.util.regex.*;

public class CapitalAfterLowercase {
    public static void main(String[] args) {
        String text = "This is an example AbcDefGhi of finding patterns.";

        if (text == null || text.isEmpty()) {
            System.out.println("Текст не может быть пустым.");
            return;
        }

        try {
            Pattern pattern = Pattern.compile("([a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);
            StringBuffer result = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(result, matcher.group(1) + "!" + matcher.group(2) + "!");
            }
            matcher.appendTail(result);

            System.out.println("Результат: " + result.toString());
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
        } catch (IllegalStateException e) {
            System.out.println("Ошибка при замене текста: " + e.getMessage());
        }
    }
}
