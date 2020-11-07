package racingcar.domain.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.asset.CarGroupConst;
import racingcar.domain.model.Car;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.ProceedStrategy;
import racingcar.domain.strategy.StopStrategy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {

    @Test
    @DisplayName("moveCar 를 하면 car 가 전진해야 한다.")
    void moveCar() {
        String nameCsv = "0,1,2,3,4,5,6,7,8,9";
        MoveStrategy strategy = ProceedStrategy.getInstance();

        CarGroup carGroup = new CarGroup(nameCsv, strategy);
        carGroup.moveCar();

        int movedPosition = 2;
        int carNum = nameCsv
                .split(CarGroupConst.NAME_SPLIT_REGEX)
                .length;
        Integer[] expectedPositions = new Integer[carNum];
        Arrays.fill(expectedPositions, movedPosition);
        List<Integer> expectedList = Arrays.asList(expectedPositions);

        assertThat(carGroup.getPositions())
                .isEqualTo(expectedList);
    }

    @Test
    @DisplayName("가장 move  car 들이 Winner 가 된다.")
    void getWinners() {
        int carNum = 10;
        int winnerPosition = 100;
        MoveStrategy strategy = ProceedStrategy.getInstance();
        Car[] carArr = new Car[carNum];
        Function<Integer, Boolean> checkWinner = (Integer idx) -> (idx % 2 == 0);

        for (int i = 0; i < carNum; i++) {
            String name = "car" + i;
            Car car = Car.createCar(name, strategy);
            boolean isWinner = checkWinner.apply(i);
            int position = isWinner ? winnerPosition : i;
            for (int j = 0; j < position; j++) {
                car.move();
            }
            carArr[i] = car;
        }

        List<Car> cars = Arrays.asList(carArr);
        List<Car> winners = CarGroup.getWinners(cars);

        List<Car> expectedWinners = new LinkedList<Car>();
        for (int i = 0; i < carNum; i++) {
            boolean isWinner = checkWinner.apply(i);
            if (!isWinner) {
                continue;
            }
            expectedWinners.add(carArr[i]);
        }

        assertThat(winners)
                .isEqualTo(expectedWinners);
    }

    @Test
    @DisplayName("strategy 가 stop 으로 바뀌면 전진하지 않는다.")
    void setStrategy() {
        String nameCsv = "0,1,2,3,4,5,6,7,8,9";
        MoveStrategy proceedStrategy = ProceedStrategy.getInstance();
        MoveStrategy stopStrategy = StopStrategy.getInstance();

        CarGroup carGroup = new CarGroup(nameCsv, proceedStrategy);
        carGroup.moveCar();
        carGroup.setStrategy(stopStrategy);
        for (int i = 0; i < 100; i++) {
            carGroup.moveCar();
        }

        int movedPosition = 2;
        int carNum = nameCsv
                .split(CarGroupConst.NAME_SPLIT_REGEX)
                .length;
        Integer[] expectedPositions = new Integer[carNum];
        Arrays.fill(expectedPositions, movedPosition);
        List<Integer> expectedList = Arrays.asList(expectedPositions);

        assertThat(carGroup.getPositions())
                .isEqualTo(expectedList);
    }


}
