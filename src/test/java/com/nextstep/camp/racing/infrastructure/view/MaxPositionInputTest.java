package com.nextstep.camp.racing.infrastructure.view;

import com.nextstep.camp.racing.infrastructure.view.MaxPositionInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxPositionInputTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
            Arguments.of("1", "1"),
            Arguments.of("15", "15"),
            Arguments.of("-1\n8", "8"),
            Arguments.of("xyz\n12", "12")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void action_ShouldReadValidInput(String input, String expected) {
        System.setIn(new ByteArrayInputStream((input + "\n").getBytes()));

        MaxPositionInput inputElement = MaxPositionInput.create();
        inputElement.action();

        assertEquals(expected, inputElement.getValue());
    }
}
