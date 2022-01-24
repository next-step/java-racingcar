package calculator;

public class Extractor {

    public void addNumber(Number numbers, String[] values, int index) {
        if (index % 2 == 0) {
            numbers.add(values[index]);
        }
    }

    public Number extractNumbers(String[] values) {
        Number numbers = new Number();
        for (int i = 0; i < values.length; i++) {
            addNumber(numbers, values, i);
        }
        return numbers;
    }

    public void addSymbol(Symbol symbols, String[] values, int index) {
        if (index % 2 == 1) {
            symbols.add(values[index]);
        }
    }

    public Symbol extractSymbols(String[] values) {
        Symbol symbols = new Symbol();
        for (int i = 0; i < values.length; i++) {
            addSymbol(symbols, values, i);
        }
        return symbols;
    }
}
