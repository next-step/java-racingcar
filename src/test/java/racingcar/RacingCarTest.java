package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    static private Scanner scanner;

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }


    @DisplayName("입력값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-34", ":1\\2345"})
    void enterInputTest(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(() -> InputView.enterTheNumberOfCars(scanner))
                    .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> InputView.enterTheNumberOfTry(scanner))
                .isInstanceOf(RuntimeException.class);

    }
}
