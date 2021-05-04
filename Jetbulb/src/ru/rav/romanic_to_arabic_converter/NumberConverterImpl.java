package ru.rav.romanic_to_arabic_converter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberConverterImpl implements NumberConverter {

    @Override
    public int toArabic(String romanNotation) throws InvalidValueException {
        if (!validate(romanNotation)) {
            String errorMessage = "String must contain only valid roman numerals [I, V, X, L, C, D, M]";
            throw new InvalidValueException(errorMessage);
        }

        int result = 0;
        for (int i = 0; i < romanNotation.length() - 1; i++) {
            if (getValue(romanNotation.charAt(i)) < getValue(romanNotation.charAt(i + 1))) {
                result -= getValue(romanNotation.charAt(i));
            } else {
                result += getValue(romanNotation.charAt(i));
            }
        }
        result += getValue(romanNotation.charAt(romanNotation.length() - 1));

        return result;
    }

    private int getValue(char c) {
        return ConvertationTable.valueOf(String.valueOf(c)).getArabicValue();
    }

    private boolean validate(String romanNotation) {
        if (romanNotation == null || romanNotation.isBlank()) {
            return false;
        }

        for (int i = 0; i < romanNotation.length(); i++) {
            char ch = romanNotation.charAt(i);
            boolean result = Arrays.stream(ConvertationTable.values())
                    .anyMatch(c -> c.getRomanValue() == ch);
            if (!result) {
                return false;
            }
        }

        /**
         * Тут лишнее немного сделал, просто только недавно с регулярками разбирался и не сдержался валидацию
         * корректную сделать (все таки XXXXX на вход получать пожалуй тоже нежелательно)
         */
        Pattern pattern = Pattern.compile("(.)\\1{3}");
        Matcher matcher = pattern.matcher(romanNotation);
        if (matcher.find()) {
            return false;
        }

        return true;
    }

}