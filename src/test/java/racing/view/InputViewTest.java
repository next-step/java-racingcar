package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.view.InputView.readNameOfCars;
import static racing.view.InputView.readNumberOfCycles;

public class InputViewTest {
    private static final int MIN_NUMBER_CYCLES = 1;
    private static final int MAX_NUMBER_CYCLES = 20;
    private Scanner scanner;

    @AfterEach
    void tearDown() {
        scanner.close();
    }

    @Test
    @DisplayName("자동차 이름 입력받기 (정상)")
    void inputCar1() {
        mockInput("pobi,crong,honux");

        List<String> actual = readNameOfCars(scanner);
        assertThat(actual).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }

    @Test
    @DisplayName("시도 횟수 입력을 1~20으로 입력한 경우 (정상)")
    void inputCycle1() {
        mockInput("19");

        int actual = readNumberOfCycles(scanner);
        assertThat(actual).isEqualTo(19);
    }

    @ParameterizedTest(name = "{displayName} - 값: {0}")
    @ValueSource(strings = {"-1", "0", "21"})
    @DisplayName("시도 횟수 입력을 1~10이 아닌 정수를 입력한 경우 (예외)")
    void inputCycle2(String input) {
        mockInput(input);

        assertThatThrownBy(() -> readNumberOfCycles(scanner))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사이클 수는 " + MIN_NUMBER_CYCLES + "~" + MAX_NUMBER_CYCLES + "만 가능합니다.");
    }

    @ParameterizedTest(name = "{displayName} - 값: {0}")
    @ValueSource(strings = {"1.1", "-5.5", "11개"})
    @DisplayName("시도 횟수 입력을 실수, 문자열 등의 정수가 아닌 값을 입력한 경우 (예외)")
    void inputCycle3(String input) {
        mockInput(input);

        assertThatThrownBy(() -> readNumberOfCycles(scanner))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("Input은 정수만 입력 가능합니다. " + input);
    }

    void mockInput(String input) {
        InputStream inputStream = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
    }
}
