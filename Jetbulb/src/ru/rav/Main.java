package ru.rav;

import ru.rav.romanic_to_arabic_converter.InvalidValueException;
import ru.rav.romanic_to_arabic_converter.NumberConverter;
import ru.rav.romanic_to_arabic_converter.NumberConverterImpl;

public class Main {

    public static void main(String[] args) {
        NumberConverter converter = new NumberConverterImpl();

        try {
            System.out.println(converter.toArabic("XXXXI"));
        } catch (InvalidValueException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
