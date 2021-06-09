package calculator;

public class CalculatorService {
    private String str;
    private String[] splitBlank;

    public CalculatorService(String str) {
        StringsService.isBlank(str);
        this.str = str;
    }

    public void checkSymbol() {
        splitBlank = StringsService.splitString(str);
        StringsService.checkSymbol(splitBlank);
    }

    public int calculateSplitedString() {
        int result = StringsService.calculateSplitedString(splitBlank);
        return result;
    }

}
