package com.nextstep.camp.racing.infrastructure.component;

import java.io.*;
import java.util.stream.Stream;

import com.nextstep.camp.racing.infrastructure.view.component.QuantityInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuantityInputTest {

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

        QuantityInput inputElement = QuantityInput.create();
        inputElement.action();

        assertEquals(expected, inputElement.getValue());
    }
}
