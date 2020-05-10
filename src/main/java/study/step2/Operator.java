package study.step2;

import java.util.Arrays;

public enum Operator {
    ADD("+"){
        @Override
        public String apply(String x, String y) {
            return String.valueOf(Integer.parseInt(x) + Integer.parseInt(y));
        }
    };

    private final String symbol;

    private Operator(String symbol){
        this.symbol = symbol;
    }

    public abstract String apply(String x, String y);

}
