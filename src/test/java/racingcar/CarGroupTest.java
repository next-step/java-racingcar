package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    @DisplayName("가장 getPosition 값이 큰 car 들이 Winner 가 된다.")
    void getWinners() {
        int carNum = 10;
        int maxPosition = Integer.MAX_VALUE;
        Car[] carArr = new Car[carNum];
        Function<Integer, Boolean> checkWinner = (Integer idx) -> (idx % 2 == 0);

        for (int i = 0; i < carNum; i++) {
            Car car = Mockito.mock(Car.class);
            boolean isWinner = checkWinner.apply(i);
            int position = isWinner ? maxPosition : i;
            Mockito.when(
                    car.getPosition()
            ).thenReturn(position);
            carArr[i] = car;
        }

        List<Car> cars = Arrays.asList(carArr);
        CarGroup carGroup = Mockito.mock(CarGroup.class);
        Mockito.when(carGroup.getWinners(cars)).thenCallRealMethod();
        List<Car> winners = carGroup.getWinners(cars);

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
}
