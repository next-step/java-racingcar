package racinggame.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.RacingCars;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class RacingGameInputViewTest {
    @Test
    @DisplayName("자동차의 이름을 입력하지 않았다면 예외가 발생한다.")
    void testEmpty() {
        final MessageReader reader = new RacingMessageReader(
            new ByteArrayInputStream("\n".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 5자를 초과한다면 예외가 발생한다.")
    void testOverMaximumLength() {
        final MessageReader reader = new RacingMessageReader(
            new ByteArrayInputStream("여섯글자이다".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름 목록 중 5자를 초과하는 자동차 이름이 존재한다면 예외가 발생한다.")
    void testCarsOverMaximumLength() {
        final MessageReader reader = new RacingMessageReader(
            new ByteArrayInputStream("1번차,2번차,여섯글자이다,4번차".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름 목록 중 비어있는 자동차 이름이 존재한다면 예외가 발생한다.")
    void testCarsEmpty() {
        final MessageReader reader = new RacingMessageReader(
            new ByteArrayInputStream("1번차,2번차,,4번차".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름 목록이 2보다 작을 경우 예외가 발생한다.")
    void testCarsMinimumLength() {
        final MessageReader reader = new RacingMessageReader(
            new ByteArrayInputStream("1번차".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarNames)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름 목록 모두 5자 이내의 이름을 입력했다면 Cars 객체가 만들어진다.")
    void testSuccessCars() {
        final MessageReader reader = new RacingMessageReader(
            new ByteArrayInputStream("1번차,2번차,3번차".getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingMessageWriter());

        final RacingCars racingCars = racingGameInputView.inputRacingCarNames();
        assertThat(racingCars.size()).isEqualTo(3);

    }
}