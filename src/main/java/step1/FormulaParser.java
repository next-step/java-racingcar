package step1;

public interface FormulaParser<T> {
    Formula<T> parse(final String formula);
}
