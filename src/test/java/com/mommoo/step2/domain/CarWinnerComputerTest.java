package com.mommoo.step2.domain;

import com.mommoo.step2.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarWinnerComputerTest {

    @DisplayName("어떤 자동차도 출발을 하지 못했다면, 동일 선상에 있으므로 모든 자동차가 최종 우승 입니다.")
    @Test
    public void testNoneOfFinalWinnerCar() {
        List<Car> cars = createCarListByPositions(0, 0, 0);

        CarWinnerComputer carWinnerComputer = new CarWinnerComputer(cars);
        assertThat(carWinnerComputer.isWinnerNotExist()).isFalse();
        assertThat(carWinnerComputer.getWinnerCarNames()).hasSize(cars.size());
    }

    @DisplayName("이동 포지션이 가장 큰 자동차가 우승이어야 합니다.")
    @Test
    public void testBiggerPositionWillBeWinner() {
        List<Car> cars = createCarListByPositions(3, 3, 2);

        CarWinnerComputer carWinnerComputer = new CarWinnerComputer(cars);
        assertThat(carWinnerComputer.isWinnerNotExist()).isFalse();

        String[] finalWinnerCarNames = {
                cars.get(0).getName(),
                cars.get(1).getName()
        };

        String[] notWinnerCarNames = {
                cars.get(2).getName()
        };

        assertThat(carWinnerComputer.getWinnerCarNames())
                .hasSize(2)
                .containsOnly(finalWinnerCarNames)
                .doesNotContain(notWinnerCarNames);
    }

    private List<Car> createCarListByPositions(int... movePositions) {
        List<Car> cars = new LinkedList<>();
        for (int index = 0; index < movePositions.length; index++) {
            String carName = "Mommoo" + (index + 1);
            int movePosition = movePositions[index];
            Car car = new Car(carName, movePosition);
            cars.add(car);
        }

        return cars;
    }
}
