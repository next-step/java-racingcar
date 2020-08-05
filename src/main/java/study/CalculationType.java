package study;

public enum CalculationType {
    PLUS("+"),
    MINUS("-"),
    MULTYPLY("*"),
    DEVIDE("/");

    private String calculation;

    CalculationType(String calculation) {
        this.calculation = calculation;
    }

    public String getCalculation() {
        return calculation;
    }

}
