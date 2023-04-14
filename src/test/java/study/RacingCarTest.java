package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1"}, delimiter = ':')
    @DisplayName("이동하지 않는값(1), 이동하는 값(4) 에 대한 테스트")
    void moveTest(int input, int excepted) {
        racingCar.moveOrStop(input);
        assertThat(racingCar.getMoveCount()).isEqualTo(excepted);
    }
}
