package racinggame.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.RacingCars;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.*;

class RacingGameInputViewTest {
    @Test
    @DisplayName("자동차의 이름을 입력하지 않았다면 예외가 발생한다.")
    void testEmpty() {
        final MessageReader reader = new RacingGameMessageReader(
            new ByteArrayInputStream("\n".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingGameMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 5자를 초과한다면 예외가 발생한다.")
    void testOverMaximumLength() {
        final MessageReader reader = new RacingGameMessageReader(
            new ByteArrayInputStream("여섯글자이다".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingGameMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름 목록 중 5자를 초과하는 자동차 이름이 존재한다면 예외가 발생한다.")
    void testCarsOverMaximumLength() {
        final MessageReader reader = new RacingGameMessageReader(
            new ByteArrayInputStream("1번차,2번차,여섯글자이다,4번차".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingGameMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름 목록 중 비어있는 자동차 이름이 존재한다면 예외가 발생한다.")
    void testCarsEmpty() {
        final MessageReader reader = new RacingGameMessageReader(
            new ByteArrayInputStream("1번차,2번차,,4번차".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingGameMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름 목록이 2보다 작을 경우 예외가 발생한다.")
    void testCarsMinimumLength() {
        final MessageReader reader = new RacingGameMessageReader(
            new ByteArrayInputStream("1번차".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingGameMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름 목록 모두 5자 이내의 이름을 입력했다면 Cars 객체가 만들어진다.")
    void testSuccessCars() {
        final MessageReader reader = new RacingGameMessageReader(
            new ByteArrayInputStream("1번차,2번차,3번차".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingGameMessageWriter());

        final RacingCars racingCars = racingGameInputView.inputRacingCarNames();
        assertThat(racingCars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("1이상의 라운드를 입력하면 해당 값을 반환한다.")
    void testValidRoundTest() {
        final MessageReader reader = new RacingGameMessageReader(
            new ByteArrayInputStream("3".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingGameMessageWriter());
        assertThat(racingGameInputView.inputRacingRoundCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("1미만 또는 숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    void testInValidRoundTest() {
        final MessageReader reader = new RacingGameMessageReader(
            new ByteArrayInputStream("0".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingGameMessageWriter());
        assertThatThrownBy(racingGameInputView::inputRacingRoundCount)
            .isExactlyInstanceOf(IllegalArgumentException.class);

        final MessageReader reader2 = new RacingGameMessageReader(
            new ByteArrayInputStream("ㄴ".getBytes())
        );
        final RacingGameInputView racingGameInputView2 = new RacingGameInputView(reader2, new RacingGameMessageWriter());
        assertThatThrownBy(racingGameInputView2::inputRacingRoundCount)
            .isExactlyInstanceOf(InputMismatchException.class);
    }
}