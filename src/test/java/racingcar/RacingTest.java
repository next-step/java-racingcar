package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.strategyTest.MoveStrategy;
import racingcar.strategyTest.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    @DisplayName("MAX_POSITION == 4")
    public void updateMaxPosition_ReturnTrue() {
        List<RacingCar> racingCarList = new ArrayList<RacingCar>();
        racingCarList.add(new RacingCar("test", 4));
        racingCarList.add(new RacingCar("test2", 3));

        Racing racing = new Racing();

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
        Racing racing = new Racing();
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        racing.runRacingRound(racingCars.statusOfRacingCars(), randomMoveStrategy);

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
        Racing racing = new Racing();
        int numberOfTrials = 4;

        while (numberOfTrials > 0) {
            racing.runRacingRound(racingCars.statusOfRacingCars(), randomMoveStrategy);
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

        Racing racing = new Racing();

        MoveStrategy moveStrategy = () -> true;
        racing.runRacingRound(racingCarList,moveStrategy);

        List<String> result = racing.makeWinnerList(racingCarList);

        assertThat(result.get(0)).isEqualTo("test2");
    }

    @Test
    @DisplayName("자동차 maxPostionList 만들기")
    public void findWinner() {
        RacingCar racingCar = new RacingCar("test", 4);
        RacingCar racingCar2 = new RacingCar("test2", 5);
        RacingCar racingCar3 = new RacingCar("test3", 5);
        RacingCar racingCar4 = new RacingCar("test4", 3);

        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(racingCar);
        racingCars.add(racingCar2);
        racingCars.add(racingCar3);
        racingCars.add(racingCar4);

        // carPostionsList
        Racing racing = new Racing();

        List<Integer> carPositions = racing.makeCarPostionList(racingCars);

        assertThat(carPositions.get(0)).isEqualTo(4);
        assertThat(carPositions.get(1)).isEqualTo(5);
        assertThat(carPositions.get(2)).isEqualTo(5);
        assertThat(carPositions.get(3)).isEqualTo(3);

    }

    @Test
    @DisplayName("자동차 maxPosition 찾기 5반환")
    public void maxPosition_ReturnFive() {
        List<Integer> carPositions = List.of(3,4,5,5);

        Racing racing = new Racing();

        int maxPosition = racing.recordMaxPosition(carPositions);

        assertThat(maxPosition).isEqualTo(5);

    }

}