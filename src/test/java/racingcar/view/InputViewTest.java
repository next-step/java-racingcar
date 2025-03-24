package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"3,5", "4,5"})
    @DisplayName("자동차 대수와 시도할 회수를 순서대로 입력받는 안내문구를 출력하고 입력받는다.")
    void printGuideMessage(int carNumber, int tryCount) {
        String in = String.format("%d%n%d%n", carNumber, tryCount);
        System.setIn(new ByteArrayInputStream(in.getBytes())); //setIn() 이후에 new Scanner(System.in)을 호출해야 동작함.
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        InputView inputView = new InputView();
        inputView.getCarCount();
        inputView.getRunCount();

        List<String> expected = List.of("자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?");
        assertThat(out.toString()).contains(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3\n", "0\n"})
    @DisplayName("자동차 대수는 양수가 아니면, 에러가 발생한다.")
    void throwIfCarCountPositive(String carCount) {
        System.setIn(new ByteArrayInputStream(carCount.getBytes()));

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::getCarCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0\n", "-1\n"})
    @DisplayName("시도할 회수는 양수가 아니면, 에러가 발생한다.")
    void throwIfRunCountPositive(String runCount) {
        System.setIn(new ByteArrayInputStream(runCount.getBytes()));

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::getRunCount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}