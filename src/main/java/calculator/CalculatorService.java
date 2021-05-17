package calculator;

public class CalculatorService {
    private String str;
    private String[] splitBlank;

    public CalculatorService(String str) {
        this.str = str;
    }

    public void isBlank() {
        StringsService.isBlank(str);

    }

    public void checkSymbok() {
        splitBlank = StringsService.splitString(str);
        StringsService.checkSymbol(splitBlank);
    }

    public int calculateSplitedString() {
        int result = StringsService.calculateSplitedString(splitBlank);
        return result;
    }

}
