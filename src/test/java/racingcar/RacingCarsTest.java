package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.strategyTest.GoMoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    @DisplayName("자동차 객체 여러개 생성 되는지 확인")
    public void checkRacingCarsObject() {
        String[] test = new String[]{"pobi", "next", "step", "fight", "test"};
        RacingCars racingCars = new RacingCars(test);

        assertThat(racingCars.statusOfRacingCars()).hasSize(5);
    }

    @Test
    @DisplayName("racingCars 방어적 복사 확인")
    public void checkRacingCarsCopyObject() {
        String[] carList = new String[]{"pobi", "next", "step", "fight", "test"};
        List<RacingCar> originCarList = new ArrayList<>();

        for(String carName : carList) {
            originCarList.add(new RacingCar(carName));
        }

        RacingCars racingCars = new RacingCars(originCarList);
        List<RacingCar> racingCarList = racingCars.statusOfRacingCars();

        originCarList.add(new RacingCar("test5"));

        assertThat(originCarList.size()).isEqualTo(6);
        assertThat(racingCarList.size()).isEqualTo(5);

        //origin만 move
        for(int i = 0; i<carList.length; i++) {
            originCarList.get(i).tryToMove(new GoMoveStrategy());
        }
        // RacingCars 만 방어적 복사 RacingCar는 아님
        for(int i = 0; i<5; i++) {
            assertThat(originCarList.get(i).position()).isEqualTo(racingCarList.get(i).position());
        }
    }

    @Test
    @DisplayName("runRacingRound를 통해 자동차 5대를 움직여 position =1 1이하 값인지 확인")
    public void runRacingRound_ReturnPositionOne() {
        String[] test = new String[]{"pobi", "next", "step", "fight", "test"};
        RacingCars racingCars = new RacingCars(test);
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        racingCars.runRacingRound(randomMoveStrategy);

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

        int numberOfTrials = 4;

        while (numberOfTrials > 0) {
            racingCars.runRacingRound(randomMoveStrategy);
            numberOfTrials--;
        }

        assertThat(racingCars.statusOfRacingCars()).hasSize(5);
        assertThat(racingCars.statusOfRacingCars().get(0).position())
                .isLessThanOrEqualTo(4);
    }

    @Test
    @DisplayName("자동차 maxPostionList 만들기")
    public void findMaxPositionTest_ReturnFive() {
        RacingCar racingCar = new RacingCar("test", 4);
        RacingCar racingCar2 = new RacingCar("test2", 5);
        RacingCar racingCar3 = new RacingCar("test3", 5);
        RacingCar racingCar4 = new RacingCar("test4", 3);

        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(racingCar);
        racingCarList.add(racingCar2);
        racingCarList.add(racingCar3);
        racingCarList.add(racingCar4);

        // carPostionsList
        RacingCars racingCars = new RacingCars(racingCarList);

        int maxPosition = racingCars.findMaxPosition();

        assertThat(maxPosition).isEqualTo(5);
    }

    @Test
    @DisplayName("5대 자동차, 4번 움직임 시도(postion max값 == 4)인 racing 확인")
    public void makeWinnerListTest_ReturnTest2() {
        RacingCar racingCar = new RacingCar("test", 4);
        RacingCar racingCar2 = new RacingCar("test2", 5);
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(racingCar);
        racingCarList.add(racingCar2);

        RacingCars racingCars = new RacingCars(racingCarList);

        MoveStrategy moveStrategy = () -> true;
        racingCars.runRacingRound(moveStrategy);

        List<String> result = racingCars.makeWinnerList();

        assertThat(result.get(0)).isEqualTo("test2");
    }

}