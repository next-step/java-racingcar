package calculator;

public class Expression {
    private Integer x;
    private FourPointOperation operator;
    private String y;

    public Expression(Integer x, FourPointOperation operator, String y) {
        this.x = x;
        this.operator = operator;
        this.y = y;
    }

    public FourPointOperation getOperator() {
        return operator;
    }

    public Integer getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}
