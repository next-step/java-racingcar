public class CalculatorInputText {

    private final String str;
    private StringSplitPolicy stringSplitPolicy;

    public CalculatorInputText(String str) {
        this.str = str;
        this.stringSplitPolicy = new StringSplitPolicy(str);
    }

    public boolean isBlank() {
        return str == null || str.isBlank();
    }

    public String[] splitByPolicy() {
        return stringSplitPolicy.splitByPolicy();
    }
}