package edu.nextstep.camp.racingcar.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void printResult_ShouldPrintFormattedOutput() {
        // Given
        List<String> cars = Arrays.asList("--", "-", "---");

        // When
        ResultView.printResult(cars);

        // Then
        String expectedOutput = "실행 결과\n--\n-\n---\n\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
