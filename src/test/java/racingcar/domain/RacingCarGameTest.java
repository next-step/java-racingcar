package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    @DisplayName("입력된 자동차 대수만큼 RacingCar 객체를 생성한다")
    void createCarList_자동차대수(int carCount) {
        List<RacingCar> carList = RacingCarGame.createCarList(carCount);
        int actual = carList.size();
        int expected = carCount;

        assertThat(actual).isEqualTo(expected);
    }
}