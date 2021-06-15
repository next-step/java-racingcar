package calculate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EnumCalculator {
    enum Operation {
        EMPTY("없음") {
            @Override
            double apply(double x, double y) {
                return 0;
            }
        },
        PLUS("+") {
            @Override
            double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            @Override
            double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            @Override
            double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            @Override
            double apply(double x, double y) {
                return x / y;
            }
        };
        private final String symbol;

        private Operation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

        abstract double apply(double x, double y);

    }

    @Test
    void enum123() {

        double a = 1;
        double b = 2;
        String method = "/";

        double result = Arrays.stream(Operation.values()).filter(operation -> operation.symbol == method).findFirst().get().apply(a, b);

        System.out.println(result);
    }
}
