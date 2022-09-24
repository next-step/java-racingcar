package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @ParameterizedTest(name = "차량 대수 입력")
    @ValueSource(strings = {"3"})
    void 차량대수_입력(String input) {
        Scanner scanner = scannerIn(input);
        assertThat(InputView.inputCars(scanner)).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest(name = "시도 회수 입력")
    @ValueSource(strings = {"5"})
    void inputTimes(String input) {
        Scanner scanner = scannerIn(input);
        assertThat(InputView.inputTimes(scanner)).isEqualTo(Integer.parseInt(input));
    }

    private Scanner scannerIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }




}
