import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99, and it was $20 last week.";

        if (text == null || text.isEmpty()) {
            System.out.println("Текст для анализа отсутствует.");
            return;
        }

        try {
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);

            System.out.println("Found numbers:");
            boolean found = false;
            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }
            if (!found) {
                System.out.println("В тексте не найдено чисел.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
        }
    }
}
