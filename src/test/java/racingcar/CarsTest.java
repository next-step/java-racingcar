package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Score;
import racingcar.domain.Scores;
import racingcar.dto.UserInput;
import racingcar.strategy.MovableNumberGeneratorStrategy;
import racingcar.strategy.NumberGeneratorStrategy;

import java.util.Arrays;
import java.util.List;

@DisplayName("Cars 객체 테스트")
public class CarsTest {

    @DisplayName("입력받은 차의 이름 수 만큼 Car 를 생성한다")
    @Test
    void carSizeTest() {
        List<String> carNames = Arrays.asList("korea", "japan", "china");

        Cars cars = new Cars(carNames);
        System.out.println("cars : " + cars.findCarsCount());

        Assertions.assertThat(cars.findCarsCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름 5자리를 초과하면 예외가 발생한다")
    void 자동차_이름_예외_테스트() {
        List<String> carNames = Arrays.asList("UnitedKingdom");
        Assertions.assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과 할 수 없습니다");
    }

    @Test
    @DisplayName("자동차들이 움직인 후 현재 스코어를 반환한다")
    void 자동차_move_테스트() {
        NumberGeneratorStrategy numberGeneratorStrategy = new MovableNumberGeneratorStrategy();
        List<String> carNames = Arrays.asList("korea", "japan", "china");
        Cars cars = new Cars(carNames);
        Scores scores = cars.move(numberGeneratorStrategy);
        List<Score> allScores = scores.findAllScores();

        Assertions.assertThat(allScores)
                .usingDefaultElementComparator()
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(
                        new Score(1, "korea"),
                        new Score(1, "japan"),
                        new Score(1, "china")
                );
    }
}
