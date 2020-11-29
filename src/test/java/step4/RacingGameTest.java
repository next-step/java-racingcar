package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @DisplayName("입력한 자동차 이름수와 같은 자동차 리스트가 생성되었는지 및 초기 위치 테스트")
    @ValueSource(strings = {"bmw,benz,kia"})
    void is_equal_to_car_number(String carNames) {
        RacingGame racingGame = new RacingGame(carNames.split(","), 4);
        List<Car> cars = racingGame.makeCarList(carNames.split(","));
        assertThat(cars.size()).isEqualTo(carNames.split(",").length);
        cars.forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
    }

}