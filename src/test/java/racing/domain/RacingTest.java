package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @DisplayName(value = "carNames에서 얻은 자동차 수만큼 차를 생성한다.")
    @Test
    void createCar() {
        List<Car> cars = CarGenerator.createCars(Arrays.asList("a", "b", "c", "d"), new RandomMoveRule());
        Racing racing = new Racing(cars, new Round(4));
        assertThat(racing.getCars()).hasSize(4);
    }

    @Test
    void race() {
        Round round = new Round(1);
        Racing racing = new Racing(Arrays.asList(new Car("a", () -> true), new Car("b", () -> false)), round);

        racing.race();
        List<CarResult> lastRoundResult = round.getRacingResult().getLastRoundResult();

        assertThat(lastRoundResult.get(0).getName()).isEqualTo("a");
        //distance확인, b의 distance도 확인
    }

}
