package study.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("최태훈");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1"}, delimiter = ':')
    @DisplayName("이동하지 않는값(1), 이동하는 값(4) 에 대한 테스트")
    void moveTest(int input, int excepted) {
        racingCar.moveOrStop(input);
        assertThat(racingCar.isSameMoveCount(excepted)).isTrue();
    }


    @Test
    @DisplayName("자동차의 이름이 5글자 이상일 경우 IllegalArgumenetException을 던진다")
    void maxLengthTest() {
        String name = "최태훈김정환";

        assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사용자의 이름의 길이는 5이상으로 작성할수 없습니다.");
    }
}
