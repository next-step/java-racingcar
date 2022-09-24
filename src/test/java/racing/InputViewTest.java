package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class InputViewTest {

    InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @ParameterizedTest(name = "차량 대수 입력")
    @ValueSource(strings = {"3 4"})
    void 차량대수_시도회수_입력(String input) {
        Scanner scanner = scannerIn(input);
        inputView.inputView(scanner);

        Assertions.assertThat(inputView.getCars()).isEqualTo(3);
        Assertions.assertThat(inputView.getTimes()).isEqualTo(4);

    }

    private Scanner scannerIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

}
