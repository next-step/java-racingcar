package step1;

public final class FormulaParserFactory {
    public static FormulaParser sequentialInteger() {
        return new SequentialIntegerFormulaParser();
    }
}
