package level2;

public enum Operator {
    PLUS("+") {
        @Override
        int calculate(Number number1, Number number2) {
            return number1.getValue() + number2.getValue();
        }
    }, MINUS("-"){
        @Override
        int calculate(Number number1, Number number2) {
            return number1.getValue() - number2.getValue();
        }
    }, MULTIPY("*") {
        @Override
        int calculate(Number number1, Number number2) {
            return number1.getValue() * number2.getValue();
        }
    }, DEVIDE("/") {
        @Override
        int calculate(Number number1, Number number2) {
            return number1.getValue() / number2.getValue();
        }
    };

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public boolean isEqualTo(String value) {
        if(this.value.equals(value)) {
            return true;
        }
        return false;
    }

    abstract int calculate(Number number1, Number number2);
}
