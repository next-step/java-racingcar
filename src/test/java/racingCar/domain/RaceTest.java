package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RaceTest {

    Race race;

    @DisplayName("자동차 대수가 0대 이하일 경우 IllegalArgumentException throw 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5, -7})
    void inputNotDualNumberTest(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            race = new Race(input);
        }).withMessageMatching("자동차 대수는 1대 이상이어야 합니다.");
    }

    @DisplayName("자동차 대수가 1대 이상일 경우 객체 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void inputDualNumberTest(int input) {
        assertThat(new Race(input)).isInstanceOf(Race.class);
    }

}