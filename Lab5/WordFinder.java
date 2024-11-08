import java.util.regex.*;
import java.util.Scanner;

public class WordFinder {
    public static void main(String[] args) {
        String text = "Apple and banana are the best fruits.";
        char letter = 'a';

        try {
            if (text == null || text.isEmpty()) {
                System.out.println("Текст не может быть пустым или null.");
                return;
            }

            if (!Character.isLetter(letter)) {
                System.out.println("Символ должен быть буквой.");
                return;
            }

            Pattern pattern = Pattern.compile("\\b" + letter + "[a-zA-Z]*", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            System.out.println("Слова, начинающиеся с буквы '" + letter + "':");
            boolean found = false;
            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }

            if (!found) {
                System.out.println("Слова, начинающиеся с указанной буквы, не найдены.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
        }
    }
}
