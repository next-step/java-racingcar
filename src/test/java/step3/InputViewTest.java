package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class InputViewTest {

    private InputView inputView;
    private final ScannerInterface mockScanner = Mockito.mock(ScannerInterface.class);

    @BeforeEach
    void setUp() {
        inputView = new InputView(mockScanner);
    }

    @Test
    @DisplayName("자동차 대수를 정할 때 숫자가 아닌 값을 받으면 RumtimeException 을 발생시킵니다.")
    void inputString() {
        // given
        String input = "abc";
        doReturn(input).when(mockScanner).getNext();

        // when
        // then
        assertThatThrownBy(inputView::setParticipantCarNumber)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("양의 정수 값만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 대수를 정할 때 정수가 아닌 값을 받으면 RuntimeException 을 발생시킵니다.")
    void inputDecimal() {
        // given
        String input = "3.5";
        doReturn(input).when(mockScanner).getNext();

        // when
        // then
        assertThatThrownBy(inputView::setParticipantCarNumber)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("양의 정수 값만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 대수를 정할 때 음수 값을 받으면 RuntimeException 을 발생시킵니다.")
    void inputNegativeNumber() {
        // given
        String input = "-5";
        doReturn(input).when(mockScanner).getNext();

        // when
        // then
        assertThatThrownBy(inputView::setParticipantCarNumber)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수 값은 불가능합니다.");
    }

    @Test
    @DisplayName("자동차 대수를 정할 때 양의 정수를 받으면 해당 문자열을 정수형으로 바꿔서 반환해준다.")
    void setParticipantCarNumber() {
        // given
        String input = "5";
        doReturn(input).when(mockScanner).getNext();

        // when
        int result = inputView.setParticipantCarNumber();
        // then
        assertThat(result).isEqualTo(5);
    }
    
    @Test
    @DisplayName("시도할 횟수를 정할때 숫자가 아닌 값을 받으면 RumtimeException 을 발생시킵니다.")
    void inputStringChance() {
        // given
        String input = "abc";
        doReturn(input).when(mockScanner).getNext();

        // when
        // then
        assertThatThrownBy(inputView::setRacingChance)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("양의 정수 값만 가능합니다.");
    }

    @Test
    @DisplayName("시도할 횟수를 정할때 정수가 아닌 값을 받으면 RuntimeException 을 발생시킵니다.")
    void inputDecimalChance() {
        // given
        String input = "3.5";
        doReturn(input).when(mockScanner).getNext();

        // when
        // then
        assertThatThrownBy(inputView::setRacingChance)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("양의 정수 값만 가능합니다.");
    }

    @Test
    @DisplayName("시도할 횟수를 정할때 음수 값을 받으면 RuntimeException 을 발생시킵니다.")
    void inputNegativeNumberChance() {
        // given
        String input = "-5";
        doReturn(input).when(mockScanner).getNext();

        // when
        // then
        assertThatThrownBy(inputView::setRacingChance)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수 값은 불가능합니다.");
    }

    @Test
    @DisplayName("시도할 횟수를 정할때 양의 정수를 받으면 해당 문자열을 정수형으로 바꿔서 반환해준다.")
    void setParticipantCarNumberChance() {
        // given
        String input = "5";
        doReturn(input).when(mockScanner).getNext();

        // when
        int result = inputView.setRacingChance();
        // then
        assertThat(result).isEqualTo(5);
    }
}