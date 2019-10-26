package step1;

public class FormulaParserFactory {
    public static FormulaParser sequential() {
        return new SequentialFormulaParser();
    }
}
