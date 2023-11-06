package step3.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarRacingInputControllerTest {

    private CarRacingInputController successCarRacingInputController;
    private CarRacingInputController errorCarRacingInputController;

    @BeforeEach
    void setUp() {
        MySuccessTestScanner successTestScanner = new MySuccessTestScanner();
        successCarRacingInputController = new CarRacingInputController(successTestScanner);

        MyErrorTestScanner errorTestScanner = new MyErrorTestScanner();
        errorCarRacingInputController = new CarRacingInputController(errorTestScanner);
    }

    @Test
    @DisplayName("자동차 대수를 정할 때 입력한 양의 정수를 반환해줍니다.")
    void getCarCount() {
        // given
        // when
        int result = successCarRacingInputController.inputParticipantCarNumber();
        // then
        assertThat(result).isEqualTo(4);
    }
    
    @Test
    @DisplayName("자동차 대수를 정할 때 양의 정수가 아닌 값을 받으면 RumtimeException 을 발생시킵니다.")
    void notPositiveNumberCarCount() {
        // given
        // when
        // then
        assertThatThrownBy(() -> errorCarRacingInputController.inputParticipantCarNumber())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("양의 정수 값만 가능합니다.");
    }

    @Test
    @DisplayName("시도할 횟수를 정할 때 입력한 양의 정수를 반환해줍니다.")
    void getChance() {
        // given
        // when
        int result = successCarRacingInputController.inputRacingChance();
        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("시도할 횟수를 정할 때 양의 정수가 아닌 값을 받으면 RuntimeException을 발생시킵니다.")
    void notPositiveChance() {
        // given
        // when
        // then
        assertThatThrownBy(() -> errorCarRacingInputController.inputRacingChance())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("양의 정수 값만 가능합니다.");
    }
}