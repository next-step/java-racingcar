package study02;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class StringCalculatorResultValue {

    public static Stream<Arguments> Test01() {
        return Stream.of(
            Arguments.of(
                    "2 + 3",
                    new Operand[]{new Operand(3), new Operand(2)},
                    new Operator[]{Operator.PLUS}
            ),
            Arguments.of(
                    "5 + 0 - 2",
                    new Operand[]{new Operand(2), new Operand(0), new Operand(5)},
                    new Operator[]{Operator.MINUS, Operator.PLUS}
            ),
            Arguments.of(
                    "4 * 3 / 2 + 5 - 1",
                    new Operand[]{new Operand(1), new Operand(5), new Operand(2), new Operand(3), new Operand(4)},
                    new Operator[]{Operator.MINUS, Operator.PLUS, Operator.DIVIDE, Operator.TIMES}
            )
        );
    }

    public static Stream<Arguments> Test03() {
        return Stream.of(
                Arguments.of(
                        "2 + 3",
                        5
                ),
                Arguments.of(
                        "7 + 11",
                        18
                ),
                Arguments.of(
                        "0 + 0",
                        0
                )
        );
    }

    public static Stream<Arguments> Test04() {
        return Stream.of(
                Arguments.of(
                        "10 - 2",
                        8
                ),
                Arguments.of(
                        "9 - 6",
                        3
                ),
                Arguments.of(
                        "2 - 0",
                        2
                )
        );
    }

    public static Stream<Arguments> Test05() {
        return Stream.of(
                Arguments.of(
                        "10 * 5",
                        50
                ),
                Arguments.of(
                        "7 * 9",
                        63
                ),
                Arguments.of(
                        "8 * 0",
                        0
                )
        );
    }

    public static Stream<Arguments> Test06() {
        return Stream.of(
                Arguments.of(
                        "4 / 2",
                        2
                ),
                Arguments.of(
                        "15 / 3",
                        5
                ),
                Arguments.of(
                        "20 / 2",
                        10
                )
        );
    }

    public static Stream<Arguments> Test07() {
        return Stream.of(
                Arguments.of(
                        "2 + 4 + 3",
                        9
                ),
                Arguments.of(
                        "5 + 5 + 5 + 7 + 1",
                        23
                ),
                Arguments.of(
                        "24 - 12 - 10 - 0",
                        2
                ),
                Arguments.of(
                        "2 * 3 * 2 * 2",
                        24
                ),
                Arguments.of(
                        "32 / 2 / 4",
                        4
                )
        );
    }

    public static Stream<Arguments> Test08() {
        return Stream.of(
                Arguments.of(
                        "2 + 4 - 1 * 3 / 5",
                        3
                ),
                Arguments.of(
                        "2 + 3 * 4 / 2",
                        10
                ),
                Arguments.of(
                        "10 + 0 - 0 * 0 + 2 / 2",
                        1
                ),
                Arguments.of(
                        "7 * 2 + 6 - 0 / 4",
                        5
                ),
                Arguments.of(
                        "1 + 1 + 1 - 1 - 1 * 1 * 1 / 1 / 1",
                        1
                )
        );
    }
}
