package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.manager.RacingManager;
import step3.manager.RandomManager;

import java.util.ArrayList;
import java.util.List;

class RacingCarGroupTest {

    private List<Car> cars;

    @BeforeEach
    private void createCars() {
        RacingManager racingManager = new RandomManager();

        cars = new ArrayList<>();
        cars.add(new Car(racingManager));
        cars.add(new Car(racingManager));
        cars.add(new Car(racingManager));
    }

    @Test
    @DisplayName("생성한 자동차 댓수만큼 위치 갯수를 반환한다.")
    public void carRunOrStop() {

        RacingCarGroup racingCarGroup = new RacingCarGroup(cars);

        List<Count> count = racingCarGroup.carsCurrentPosition();

        Assertions.assertThat(count.size()).isEqualTo(3);
    }

}