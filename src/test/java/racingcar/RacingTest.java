package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.strategyTest.MoveStrategy;
import racingcar.strategyTest.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    @DisplayName("MAX_POSITION == 4")
    public void updateMaxPosition_ReturnTrue() {
        List<RacingCar> racingCarList = new ArrayList<RacingCar>();
        racingCarList.add(new RacingCar("test", 4));
        racingCarList.add(new RacingCar("test2", 3));

        Racing racing = new Racing(racingCarList);

        for (RacingCar racingCar : racingCarList) {
            racing.updateMaxPosition(racingCar.position());
        }

        int result = racing.maxPosition();

        assertThat(result).isEqualTo(4);
    }
    @Test
    @DisplayName("runRacingRound를 통해 자동차 5대를 움직여 position =1 1이하 값인지 확인")
    public void runRacingRound_ReturnPositionOne() {
        String[] test = new String[]{"pobi", "next", "step", "fight", "test"};
        RacingCars racingCars = new RacingCars(test);
        Racing racing = new Racing(racingCars.statusOfRacingCars());
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        racing.runRacingRound(randomMoveStrategy);

        assertThat(racingCars.statusOfRacingCars().get(0).position())
                .isLessThanOrEqualTo(1);
        assertThat(racingCars.statusOfRacingCars().get(1).position())
                .isLessThanOrEqualTo(1);
        assertThat(racingCars.statusOfRacingCars().get(2).position())
                .isLessThanOrEqualTo(1);
        assertThat(racingCars.statusOfRacingCars().get(3).position())
                .isLessThanOrEqualTo(1);
        assertThat(racingCars.statusOfRacingCars().get(4).position())
                .isLessThanOrEqualTo(1);
    }

    @Test
    @DisplayName("5대 자동차, 4번 움직임 시도(postion max값 == 4)인 racing 확인")
    public void runRacingRound_ReturnPositionUnderFour() {
        String[] test = new String[]{"pobi", "next", "step", "fight", "test"};
        RacingCars racingCars = new RacingCars(test);
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        Racing racing = new Racing(racingCars.statusOfRacingCars());
        int numberOfTrials = 4;

        while (numberOfTrials > 0) {
            racing.runRacingRound(randomMoveStrategy);
            numberOfTrials--;
        }

        assertThat(racingCars.statusOfRacingCars()).hasSize(5);
        assertThat(racingCars.statusOfRacingCars().get(0).position())
                .isLessThanOrEqualTo(4);
    }
    @Test
    @DisplayName("5대 자동차, 4번 움직임 시도(postion max값 == 4)인 racing 확인")
    public void makeWinnerListTest() {
        RacingCar racingCar = new RacingCar("test", 4);
        RacingCar racingCar2 = new RacingCar("test2", 5);
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(racingCar);
        racingCarList.add(racingCar2);

        Racing racing = new Racing(racingCarList);

        MoveStrategy moveStrategy = () -> true;
        racing.runRacingRound(moveStrategy);

        List<String> result = racing.makeWinnerList();

        assertThat(result.get(0)).isEqualTo("test2");
    }

}