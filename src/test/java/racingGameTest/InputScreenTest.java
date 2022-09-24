package racingGameTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.InputScreen;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputScreenTest {

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of("1\n", "2")
        );
    }
    private Scanner scanner;

    @ParameterizedTest
    @MethodSource("provideInput")
    @DisplayName("입력 값을 list로 반환한다")
    void askInputTest(String carNum, String tryNum) {
        InputStream input = createInputStream(carNum, tryNum);
        System.setIn(input);

        scanner = new Scanner(System.in);
        InputScreen inputScreen = new InputScreen();

        assertThat(inputScreen.askInput(scanner)).isEqualTo(List.of(1, 2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-2"})
    @DisplayName("음수를 입력시 IllegalArgumentException을 던진다.")
    void if_input_negative_throw_exception(String input) {
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);
        InputScreen inputScreen = new InputScreen();
        scanner =new Scanner(System.in);
        assertThrows(IllegalArgumentException.class, () ->{
           inputScreen.askInput(scanner);
        });
    }

    private InputStream createInputStream(String carNum, String tryNUm) {
        InputStream carInputStream = generateUserInput(carNum);
        InputStream tryInputStream = generateUserInput(tryNUm);
        return new SequenceInputStream(carInputStream, tryInputStream);
    }

    public static InputStream generateUserInput(String  input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
