package calculator;

public class CalculatorService {
    private String[] splitFormula;

    public CalculatorService(String inputFormula) {
        StringsService.isBlank(inputFormula);
        this.splitFormula = inputFormula.split(" ");
    }

    public void checkSymbol() {
        StringsService.checkSymbol(splitFormula);
    }

    public int calculateSplitedString() {
        return StringsService.calculateSplitedString(splitFormula);
    }

}
