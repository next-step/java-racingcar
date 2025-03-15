package edu.nextstep.camp.racingcar.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 자동차의_현재_위치가_잘_출력되는지_테스트() {
        // Given
        List<Car> cars = Arrays.asList(new Car(2), new Car(1), new Car(3));

        // When
        ResultView.printCarStatus(cars);

        // Then
        String expectedOutput = "--\n-\n---\n\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 결과_메시지가_잘_출력되는지_테스트() {
        // When
        ResultView.printResultMessage();

        // Then
        assertThat(outputStream.toString()).isEqualTo("실행 결과\n");
    }
}
