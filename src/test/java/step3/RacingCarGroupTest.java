package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.manager.RacingManager;
import step3.manager.RandomManager;

import java.util.ArrayList;
import java.util.List;

class RacingCarGroupTest {

    private static RacingCarGroup CAR_GROUP;
    private final static RacingManager MANAGER = new RandomManager();

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    @DisplayName("자동차 리스트를 전달하면 해당 자동차 리스트만큼 그룹이 지어진다")
    public void carRunOrStop(int input) {
        RacingManager racingManager = new RandomManager();
        List<Car> cars = new ArrayList<>();
        for(int i = 0 ; i < input ; ++i) {
            cars.add(new Car(racingManager));
        }

        CAR_GROUP = new RacingCarGroup(cars);

        Assertions.assertThat(CAR_GROUP.carsCount()).isEqualTo(new Count(input));
    }
}