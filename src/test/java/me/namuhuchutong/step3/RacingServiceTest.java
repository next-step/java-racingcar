package me.namuhuchutong.step3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingServiceTest {

    @DisplayName("자동차 경주 횟수는 음수이거나 0일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void racing_times_should_not_be_negative_or_zero(int times) {
        //given
        UserInputInformation userInputInformation = new UserInputInformation();
        userInputInformation.setNumberOfCars(1);
        userInputInformation.setTimes(times);
        RacingService racingService = new RacingService();

        //when, then
        assertThrows(IllegalArgumentException.class, () -> racingService.runRacing(userInputInformation));
    }
}
