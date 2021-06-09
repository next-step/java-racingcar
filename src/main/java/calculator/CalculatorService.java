package calculator;

public class CalculatorService {
    private String inputFormula;
    private String[] splitFormula;

    public CalculatorService(String inputFormula) {
        StringsService.isBlank(inputFormula);
        this.inputFormula = inputFormula;
    }

    public void checkSymbol() {
        splitFormula = inputFormula.split(" ");
        StringsService.checkSymbol(splitFormula);
    }

    public int calculateSplitedString() {
        int result = StringsService.calculateSplitedString(splitFormula);
        return result;
    }

}
