package study.step2;

import java.util.LinkedList;
import java.util.Objects;
import java.util.function.BiConsumer;

public enum Exception {
    NULL_INPUT("입력값이 null 입니다", (String input, String message) -> {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(message);
        }
    }),
    BLANK_INPUT("입력값이 비어있습니다", (String input, String message) -> {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }),
    NOT_OPERATOR("적합한 연산자가 아닙니다 -> ", (Operator operator, String message) -> {
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException(message);
        }
    }),
    OPERATOR_SHORTAGE("수식에서 연산자가 부족합니다", (LinkedList<Operator> operators, String message) -> {
        if (operators.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    });

    private final String message;
    private final BiConsumer orElseThrow;

    <T, U> Exception(String message, BiConsumer<T, U> orElseThrow) {
        this.message = message;
        this.orElseThrow = orElseThrow;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String text) {
        return message + text;
    }

    public <T, U> void validation(T t, U u) {
        this.orElseThrow.accept(t, u);
    }

}
