package calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+"){
        @Override
        public int execute(int a, int b) {
            return a + b;
        }
    },
    SUB("-"){
        @Override
        public int execute(int a, int b) {
            return a - b;
        }
    },
    MUL("*"){
        @Override
        public int execute(int a, int b) {
            return a * b;
        }
    },
    DIV("/"){
        @Override
        public int execute(int a, int b) {
            if(b == 0){
                throw new IllegalArgumentException();
            }
            return a / b;
        }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator valueOfString(String str) {
        return Arrays.stream(Operator.values())
                .filter(i -> str.equals(i.getOperator()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public abstract int execute(int a, int b);
}
