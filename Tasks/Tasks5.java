import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.*;

public class Tasks5 {
    public static void main(String[] args){
        System.out.println(sameLetterPattern("ABAB", "CDCD")); // true
        System.out.println(sameLetterPattern("ABCBA", "BCDCB")); // true
        System.out.println(sameLetterPattern("FFGG", "CDCD")); // false
        System.out.println(sameLetterPattern("FFFF", "ABCD")); // false
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(memeSum(26, 39));       // 515
        System.out.println(memeSum(122, 81));      // 1103
        System.out.println(memeSum(1222, 30277));  // 31499
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(digitsCount(4666));           // 4
        System.out.println(digitsCount(544));            // 3
        System.out.println(digitsCount(121317));         // 6
        System.out.println(digitsCount(0));              // 1
        System.out.println(digitsCount(12345));          // 5
        System.out.println(digitsCount(1289396387328L)); // 13
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster")); // 2
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant")); // 108
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed")); // 13
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); // 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15})); // 1
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"})); // "54%"
        System.out.println(takeDownAverage(new String[]{"10%"})); // "0%"
        System.out.println(takeDownAverage(new String[]{"53%", "79%"})); // "51%"
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(canMove("Rook", "A8", "H8")); // true
        System.out.println(canMove("Bishop", "A7", "G1")); // true
        System.out.println(canMove("Queen", "C4", "D6")); // false
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(maxPossible(9328, 456));  // ➞ 9658
        System.out.println(maxPossible(523, 76));   // ➞ 763
        System.out.println(maxPossible(9132, 5564)); // ➞ 9655
        System.out.println(maxPossible(8732, 91255)); // ➞ 9755
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("==================");
        System.out.println("==================");
        System.out.println(isNew(3));     // ➞ true
        System.out.println(isNew(30));    // ➞ true
        System.out.println(isNew(321));   // ➞ false
        System.out.println(isNew(123));   // ➞ true
    }
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        return getPattern(str1).equals(getPattern(str2));
    }

    private static String getPattern(String str) {
        StringBuilder pattern = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;

        for (char c : str.toCharArray()) {
            map.putIfAbsent(c, index++);
            pattern.append(map.get(c));
        }

        return pattern.toString();
    }
    public static String memeSum(int num1, int num2) {
        StringBuilder result = new StringBuilder();
        while (num1 > 0 || num2 > 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            result.insert(0, digit1 + digit2);
            num1 /= 10;
            num2 /= 10;
        }
        return result.toString();
    }
    public static int digitsCount(long num) {
        num = Math.abs(num); // Учитываем отрицательные числа
        if (num < 10) return 1;
        return 1 + digitsCount(num / 10);
    }

    public static int totalPoints(String[] guessedWords, String scrambledWord) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : scrambledWord.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        int totalPoints = 0;

        for (String word : guessedWords) {
            if (isValidWord(word, new HashMap<>(charMap))) {
                int length = word.length();
                if (length == 3) totalPoints += 1;
                else if (length == 4) totalPoints += 2;
                else if (length == 5) totalPoints += 3;
                else if (length == 6) {
                    totalPoints += 54; // 4 очка за длину + 50 бонуса
                }
            }
        }

        return totalPoints;
    }

    private static boolean isValidWord(String word, Map<Character, Integer> charMap) {
        for (char c : word.toCharArray()) {
            if (!charMap.containsKey(c) || charMap.get(c) == 0) return false;
            charMap.put(c, charMap.get(c) - 1);
        }
        return true;
    }


    public static int longestRun(int[] nums) {
        if (nums.length == 0) return 0;

        int longest = 1;
        int currentRun = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1 || nums[i] == nums[i - 1] - 1) {
                currentRun++;
                longest = Math.max(longest, currentRun);
            } else {
                currentRun = 1; // Сбрасываем счетчик
            }
        }

        return longest;
    }

    public static String takeDownAverage(String[] scores) {
        int total = 0;
        for (String score : scores) {
            total += Integer.parseInt(score.replace("%", ""));
        }

        float currentAverage = (float) total / scores.length;
        float newAverage = currentAverage - 5.f;
        float newScore = newAverage * (scores.length + 1) - total;

        return Math.round(newScore) + "%";
    }

    public static boolean canMove(String piece, String start, String end) {
        int startX = start.charAt(0) - 'A';
        int startY = start.charAt(1) - '1';
        int endX = end.charAt(0) - 'A';
        int endY = end.charAt(1) - '1';

        switch (piece.toLowerCase()) {
            case "rook":
                return startX == endX || startY == endY;
            case "bishop":
                return Math.abs(startX - endX) == Math.abs(startY - endY);
            case "queen":
                return canMove("rook", start, end) || canMove("bishop", start, end);
            case "king":
                return Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1;
            case "knight":
                return (Math.abs(startX - endX) == 2 && Math.abs(startY - endY) == 1) ||
                        (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 2);
            case "pawn":
                return startX == endX && (endY - startY == 1 || (startY == 1 && endY - startY == 2));
            default:
                return false;
        }
    }

    public static int maxPossible(int num1, int num2) {
        // Преобразуем числа в массивы цифр
        char[] num1Digits = String.valueOf(num1).toCharArray();
        char[] num2Digits = String.valueOf(num2).toCharArray();

        // Отсортируем цифры второго числа по убыванию
        Arrays.sort(num2Digits);
        int index = num2Digits.length - 1;

        // Заменяем цифры в num1 на максимальные из num2
        for (int i = 0; i < num1Digits.length; i++) {
            if (index >= 0 && num1Digits[i] < num2Digits[index]) {
                num1Digits[i] = num2Digits[index];
                index--;
            }
        }

        return Integer.parseInt(new String(num1Digits));
    }

    private static final Map<String, Integer> timeOffsets = new HashMap<>() {
        {
            put("Los Angeles", -8 * 60);
            put("New York", -5 * 60);
            put("Caracas", -4 * 60 - 30);
            put("Buenos Aires", -3 * 60);
            put("London", 0);
            put("Rome", 1 * 60);
            put("Moscow", 3 * 60);
            put("Tehran", 3 * 60 + 30);
            put("New Delhi", 5 * 60 + 30);
            put("Beijing", 8 * 60);
            put("Canberra", 10 * 60);
        }
    };

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.US);
        try {
            Date date = sdf.parse(timestamp);
            int offsetA = timeOffsets.get(cityA);
            int offsetB = timeOffsets.get(cityB);
            int timeDifference = offsetB - offsetA;
            long newTimeInMillis = date.getTime() + timeDifference * 60 * 1000;
            Date newDate = new Date(newTimeInMillis);
            SimpleDateFormat resultFormat = new SimpleDateFormat("yyyy-M-d HH:mm");
            return resultFormat.format(newDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean isNew(int num) {
        String strNum = Integer.toString(num);
        for (int i = 1; i < num; i++) {
            String strI = Integer.toString(i);
            char[] digitsNum = strNum.toCharArray();
            char[] digitsI = strI.toCharArray();
            Arrays.sort(digitsNum);
            Arrays.sort(digitsI);
            if (Arrays.equals(digitsNum, digitsI)) {
                return false;
            }
        }
        return true;
    }


}