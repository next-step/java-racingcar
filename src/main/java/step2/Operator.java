package step2;

public enum Operator {
    SUM("+"), SUB("-"), MUL("*"), DIV("/");

    Operator(String value) {
        this.value = value;
    }

    private final String value;

    public boolean equalsValue(String value){
        return this.value.equals(value);
    }

    public int operate(int first, int second) {
        if (this == SUM) {
            return sum(first, second);
        } else if (this == SUB) {
            return sub(first, second);
        } else if (this == MUL) {
            return mul(first, second);
        }
        return div(first, second);
    }

    private int sum(int first, int second) {
        return first + second;
    }

    private int sub(int first, int second) {
        return first - second;
    }

    private int mul(int first, int second) {
        return first * second;
    }

    private int div(int first, int second) {
        return first / second;
    }
}
