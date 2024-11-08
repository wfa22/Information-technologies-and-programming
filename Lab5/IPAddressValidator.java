import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ip = "192.168.1.1";

        try {
            if (ip == null || ip.isEmpty()) {
                System.out.println("IP-адрес не может быть пустым или null.");
                return;
            }

            String ipPattern = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
            Pattern pattern = Pattern.compile(ipPattern);
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()) {
                System.out.println("IP-адрес корректен!");
            } else {
                System.out.println("IP-адрес некорректен!");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getDescription());
        } catch (NullPointerException e) {
            System.out.println("Ошибка: IP-адрес не может быть null.");
        }
    }
}
