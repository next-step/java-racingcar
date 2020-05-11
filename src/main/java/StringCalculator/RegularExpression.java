package StringCalculator;

public enum RegularExpression {

    NUMBER("^[0-9]*$"),
    ARITHMETIC("^[0-9][\\s0-9+\\-*/]*[0-9]$"),
    OPERATION("^[+\\-*/]*$");

    private final String regExp;

    RegularExpression(String regExp) {
        this.regExp = regExp;
    };

    public String getRegExp() {
        return regExp;
    };
}
