package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    private CarPlay carPlay;

    @BeforeEach
    void setUp() {
        this.carPlay = new CarPlay();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    @DisplayName("자동차 레이싱 경기 검증")
    void carRacing(String strings) {
        carPlay.carRacingStart(strings, 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"슈퍼자동차"})
    @DisplayName("5자리 자리수 검증")
    void carNameCheck(String strings) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> carPlay.carNameCheck(strings));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @DisplayName("데이터 공백 검증")
    void nullCheckTest(String strings)
    {
        carPlay.carNameCheck(strings);
    }

    @ParameterizedTest
    @ValueSource(ints = 10)
    @DisplayName("랜덤 스코어 검증")
    void randomNumberCheck(Integer ints) {
        assertThat(carPlay.racingResult(ints));
    }
}
