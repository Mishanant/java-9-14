package academy.tochkavhoda.base;

public class StringOperations {

    // 1. Возвращает суммарную длину строк, заданных массивом strings.
    public static int getSummaryLength(String[] strings) {
        int totalLength = 0;
        for (String str : strings) {
            totalLength += str.length();
        }
        return totalLength;
    }

    // 2. Возвращает двухсимвольную строку, состоящую из начального и конечного символов заданной строки.
    public static String getFirstAndLastLetterString(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        char firstChar = string.charAt(0);
        char lastChar = string.charAt(string.length() - 1);
        return String.valueOf(firstChar) + lastChar;
    }

    // 3. Возвращает true, если обе строки в позиции index содержат один и тот же символ, иначе false.
    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        if (string1 == null || string2 == null) {
            return false;
        }
        if (index < 0 || index >= string1.length() || index >= string2.length()) {
            return false;
        }
        return string1.charAt(index) == string2.charAt(index);
    }

    // 4. Возвращает true, если в обеих строках первый встреченный символ character находится в одной и той же позиции.
    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        if (string1 == null || string2 == null) {
            return false;
        }
        int pos1 = string1.indexOf(character);
        int pos2 = string2.indexOf(character);
        return pos1 == pos2;
    }

    // 5. Возвращает true, если в обеих строках первый встреченный символ character находится в одной и той же позиции.
    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        if (string1 == null || string2 == null) {
            return false;
        }
        int pos1 = string1.lastIndexOf(character);
        int pos2 = string2.lastIndexOf(character);
        return pos1 == pos2;
    }

    // 6. Возвращает true, если в обеих строках первая встреченная подстрока str начинается в одной и той же позиции.
    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        if (string1 == null || string2 == null || str == null) {
            return false;
        }
        int pos1 = string1.indexOf(str);
        int pos2 = string2.indexOf(str);
        return pos1 == pos2;
    }

    // 7. Возвращает true, если в обеих строках первая встреченная подстрока str начинается в одной и той же позиции.
    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        if (string1 == null || string2 == null || str == null) {
            return false;
        }
        int pos1 = string1.lastIndexOf(str);
        int pos2 = string2.lastIndexOf(str);
        return pos1 == pos2;
    }

    // 8. Возвращает true, если строки равны.
    public static boolean isEqual(String string1, String string2) {
        if (string1 == null && string2 == null) {
            return true;
        }
        if (string1 == null || string2 == null) {
            return false;
        }
        return string1.equals(string2);
    }

    // 9. Возвращает true, если строки равны без учета регистра.
    public static boolean isEqualIgnoreCase(String string1, String string2) {
        if (string1 == null && string2 == null) {
            return true;
        }
        if (string1 == null || string2 == null) {
            return false;
        }
        return string1.equalsIgnoreCase(string2);
    }

    // 10. Возвращает true, если строка string1 меньше строки string2.
    public static boolean isLess(String string1, String string2) {
        if (string1 == null && string2 == null) {
            return false;
        }
        if (string1 == null) {
            return true;
        }
        if (string2 == null) {
            return false;
        }
        return string1.compareTo(string2) < 0;
    }

    // 11. Возвращает true, если строка string1 меньше строки string2 без учета регистра.
    public static boolean isLessIgnoreCase(String string1, String string2) {
        if (string1 == null && string2 == null) {
            return false;
        }
        if (string1 == null) {
            return true;
        }
        if (string2 == null) {
            return false;
        }
        return string1.compareToIgnoreCase(string2) < 0;
    }

    // 12. Возвращает строку, полученную путем сцепления двух строк.
    public static String concat(String string1, String string2) {
        if (string1 == null) {
            string1 = "";
        }
        if (string2 == null) {
            string2 = "";
        }
        return string1 + string2;
    }

    // 13. Возвращает true, если обе строки string1 и string2 начинаются с одной и той же подстроки prefix.
    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        if (string1 == null || string2 == null || prefix == null) {
            return false;
        }
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    // 14. Возвращает true, если обе строки string1 и string2 заканчиваются одной и той же подстрокой suffix.
    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        if (string1 == null || string2 == null || suffix == null) {
            return false;
        }
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    // 15. Возвращает самое длинное общее "начало" двух строк.
    public static String getCommonPrefix(String string1, String string2) {
        if (string1 == null || string2 == null) {
            return "";
        }
        int minLength = Math.min(string1.length(), string2.length());
        StringBuilder commonPrefix = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            if (string1.charAt(i) == string2.charAt(i)) {
                commonPrefix.append(string1.charAt(i));
            } else {
                break;
            }
        }
        return commonPrefix.toString();
    }

    // 16. Возвращает перевернутую строку.
    public static String reverse(String string) {
        if (string == null) {
            return null;
        }
        return new StringBuilder(string).reverse().toString();
    }

    // 17. Возвращает true, если строка является палиндромом.
    public static boolean isPalindrome(String string) {
        if (string == null) {
            return false;
        }
        String reversed = reverse(string);
        return string.equals(reversed);
    }

    // 18. Возвращает true, если строка является палиндромом без учета регистра.
    public static boolean isPalindromeIgnoreCase(String string) {
        if (string == null) {
            return false;
        }
        String reversed = reverse(string);
        return string.equalsIgnoreCase(reversed);
    }

    // 19. Возвращает самый длинный палиндром (без учета регистра) из массива заданных строк.
    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        if (strings == null) {
            return "";
        }
        String longestPalindrome = "";

        for (String str : strings) {
            if (str != null && isPalindromeIgnoreCase(str) && str.length() > longestPalindrome.length()) {
                longestPalindrome = str;
            }
        }
        return longestPalindrome;
    }

    // 20. Возвращает true, если обе строки содержат один и тот же фрагмент длиной length, начиная с позиции index.
    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (string1 == null || string2 == null) {
            return false;
        }
        if (index < 0 || length < 0) {
            return false;
        }
        if (index + length > string1.length() || index + length > string2.length()) {
            return false;
        }

        String substring1 = string1.substring(index, index + length);
        String substring2 = string2.substring(index, index + length);
        return substring1.equals(substring2);
    }

    // 21. Возвращает true, если после замены символов полученные строки равны.
    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                        String string2, char replaceInStr2, char replaceByInStr2) {
        if (string1 == null && string2 == null) {
            return true;
        }
        if (string1 == null || string2 == null) {
            return false;
        }

        String modified1 = string1.replace(replaceInStr1, replaceByInStr1);
        String modified2 = string2.replace(replaceInStr2, replaceByInStr2);
        return modified1.equals(modified2);
    }

    // 22. Возвращает true, если после замены строк полученные строки равны.
    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                     String string2, String replaceInStr2, String replaceByInStr2) {
        if (string1 == null && string2 == null) {
            return true;
        }
        if (string1 == null || string2 == null ||
                replaceInStr1 == null || replaceByInStr1 == null ||
                replaceInStr2 == null || replaceByInStr2 == null) {
            return false;
        }

        String modified1 = string1.replace(replaceInStr1, replaceByInStr1);
        String modified2 = string2.replace(replaceInStr2, replaceByInStr2);
        return modified1.equals(modified2);
    }

    // 23. Возвращает true, если строка после выбрасывания из нее всех пробелов является палиндромом, без учета регистра.
    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        if (string == null) {
            return false;
        }
        String withoutSpaces = string.replace(" ", "");
        return isPalindromeIgnoreCase(withoutSpaces);
    }

    // 24. Возвращает true, если две строки равны, если не принимать во внимание все пробелы в начале и конце каждой строки.
    public static boolean isEqualAfterTrimming(String string1, String string2) {
        if (string1 == null && string2 == null) {
            return true;
        }
        if (string1 == null || string2 == null) {
            return false;
        }
        return string1.trim().equals(string2.trim());
    }

    // 25. Для заданного массива целых чисел создает текстовую строку в формате CSV.
    public static String makeCsvStringFromInts(int[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }

    // 26. Для заданного массива вещественных чисел создает текстовую строку в формате CSV.
    public static String makeCsvStringFromDoubles(double[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(String.format("%.2f", array[i]));
            if (i < array.length - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }

    // 27. То же, что и в упражнении 25, но возвращает StringBuilder.
    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        return new StringBuilder(makeCsvStringFromInts(array));
    }

    // 28. То же, что и в упражнении 26, но возвращает StringBuilder.
    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        return new StringBuilder(makeCsvStringFromDoubles(array));
    }

    // 29. Удаляет из строки символы, номера которых заданы в массиве positions.
    public static StringBuilder removeCharacters(String string, int[] positions) {
        if (string == null) {
            return new StringBuilder();
        }
        if (positions == null || positions.length == 0) {
            return new StringBuilder(string);
        }

        StringBuilder result = new StringBuilder(string);
        // Удаляем с конца, чтобы индексы не смещались
        for (int i = positions.length - 1; i >= 0; i--) {
            int pos = positions[i];
            if (pos >= 0 && pos < result.length()) {
                result.deleteCharAt(pos);
            }
        }
        return result;
    }

    // 30. Вставляет в строку символы в указанные позиции.
    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        if (string == null) {
            string = "";
        }
        if (positions == null || characters == null || positions.length != characters.length) {
            return new StringBuilder(string);
        }

        // Преобразуем строку в список символов
        java.util.List<Character> charList = new java.util.ArrayList<>();
        for (char c : string.toCharArray()) {
            charList.add(c);
        }

        // Вставляем символы в обратном порядке (с конца)
        for (int i = positions.length - 1; i >= 0; i--) {
            int pos = positions[i];
            if (pos >= 0 && pos <= charList.size()) {
                charList.add(pos, characters[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            result.append(c);
        }

        return result;
    }
}
