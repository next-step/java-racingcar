package step2.calculator.domain;

import common.util.Message;
import common.util.Preconditions;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

import static step2.calculator.domain.Operation.ErrorMessage.CAN_NOT_DIVIDE_BY_ZERO;
import static step2.calculator.domain.Operation.ErrorMessage.NOT_FOUND_MATCHED_OPERATION;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y),
    ;

    public enum ErrorMessage implements Message {
        CAN_NOT_DIVIDE_BY_ZERO("can't divide bu zero"),
        NOT_FOUND_MATCHED_OPERATION("not found matched Operation"),
        ;

        private final String message;

        public String getMessage() {
            return message;
        }

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    private final String symbol;
    private final IntBinaryOperator op;

    Operation(final String symbol, final IntBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public int apply(final int x, final int y) {
        if (this == DIVIDE && y == 0) {
            throw new IllegalArgumentException(CAN_NOT_DIVIDE_BY_ZERO.getMessage());
        }
        return op.applyAsInt(x, y);
    }

    public static Operation symbolOf(final String symbol) {
        for (final Operation op : Operation.values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException(NOT_FOUND_MATCHED_OPERATION.getMessage());
    }

    public static List<String> getSupportedSymbols() {
        return Arrays.stream(Operation.values())
                .map(op -> op.symbol)
                .collect(Collectors.toList());
    }
}