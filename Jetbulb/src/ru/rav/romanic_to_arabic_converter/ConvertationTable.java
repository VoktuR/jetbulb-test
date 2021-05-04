package ru.rav.romanic_to_arabic_converter;

enum ConvertationTable {
    I(1, 'I'),
    V(5, 'V'),
    X(10, 'X'),
    L(50, 'L'),
    C(100, 'C'),
    D(500, 'D'),
    M(1000, 'M');

    private final int arabicValue;
    private final char romanValue;

    ConvertationTable(int arabicValue, char romanValue) {
        this.arabicValue = arabicValue;
        this.romanValue = romanValue;
    }

    public int getArabicValue() {
        return arabicValue;
    }

    public char getRomanValue() {
        return romanValue;
    }
}
