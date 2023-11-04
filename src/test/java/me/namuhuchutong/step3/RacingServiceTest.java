package me.namuhuchutong.step3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingServiceTest {

    private RacingService racingService;

    private RacingRule racingRule;

    @BeforeEach
    void setUp() {
        this.racingRule = new RacingRule();
        this.racingService = new RacingService(this.racingRule);
    }

    @DisplayName("자동차 경주 횟수는 음수이거나 0일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void racing_times_should_not_be_negative_or_zero(int times) {
        //given
        UserInputInformation userInputInformation = new UserInputInformation();
        userInputInformation.setNumberOfCars(1);
        userInputInformation.setTimes(times);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> racingService.runRacing(userInputInformation));
    }

    @DisplayName("자동차 결과는 경주 횟수와 동일하다.")
    @ParameterizedTest(name = "Times: {1}, expected total: {2}")
    @CsvSource(value = {"3,5,5", "4,3,3", "1,2,2", "3,2,2"})
    void racing_result_count_is_same_as_racing_times(int numberOfCars, int times, int expected) {
        //given
        UserInputInformation userInputInformation = new UserInputInformation();
        userInputInformation.setNumberOfCars(numberOfCars);
        userInputInformation.setTimes(times);

        //when
        RacingResult racingResult = racingService.runRacing(userInputInformation);

        //then
        assertThat(racingResult.getTotalRace()).isEqualTo(expected);

    }
}
