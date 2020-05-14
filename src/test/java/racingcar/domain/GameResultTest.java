package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameResult 클래스 테스트")
public class GameResultTest {

    @Test
    @DisplayName("getResult 메소드는 자동차의 위치를 문자로 변환 후 리턴한다.")
    void getResult() {
        // given
        Car car = new Car();
        car.move();

        List<Car> cars = Arrays.asList(car, new Car());
        GameResult gameResult = new GameResult(cars);

        // when
        List<String> actual = gameResult.getResult();

        // then
        assertThat(actual).isNotNull();
        assertThat(actual).hasSize(cars.size());
        assertThat(actual.get(0)).isEqualTo("-");
    }
}
