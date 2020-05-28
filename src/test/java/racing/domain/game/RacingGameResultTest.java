package racing.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.car.Car;
import racing.domain.car.TestCarForwardBehavior;
import racing.domain.car.TestCarStopBehavior;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {
    private List<Car> carPositions;
    private List<String> winnerList;

    @BeforeEach
    void setup() {
        carPositions = new ArrayList<>();
        winnerList = new ArrayList<>();

        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        car1.move(new TestCarForwardBehavior());
        car1.move(new TestCarForwardBehavior());
        carPositions.add(car1);

        car2.move(new TestCarForwardBehavior());
        car2.move(new TestCarStopBehavior());
        carPositions.add(car2);

        car3.move(new TestCarForwardBehavior());
        car3.move(new TestCarForwardBehavior());
        carPositions.add(car3);

        winnerList.add(car1.getCarName());
        winnerList.add(car3.getCarName());
    }

    @Test
    void getWinners() {
        RacingGameResult racingGameResult = new RacingGameResult(carPositions, winnerList);

        assertThat(racingGameResult.getWinnerList()).isEqualTo(winnerList);
    }

}
