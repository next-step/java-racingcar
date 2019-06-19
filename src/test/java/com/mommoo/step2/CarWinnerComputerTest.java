package com.mommoo.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarWinnerComputerTest {

    @DisplayName("어떤 자동차도 출발을 하지 못했다면, 최종 우승은 없습니다.")
    @Test
    public void testNoneOfFinalWinnerCar() {
        List<Car> cars = createCarListByPositions(0, 0, 0);

        CarWinnerComputer carWinnerComputer = new CarWinnerComputer(cars);
        assertThat(carWinnerComputer.isWinnerNotExist()).isTrue();
        assertThat(carWinnerComputer.getWinnerCarNameList()).hasSize(0);
    }

    @DisplayName("이동 포지션이 가장 큰 자동차가 우승이어야 합니다.")
    @Test
    public void testBiggerPositionWillBeWinner() {
        List<Car> cars = createCarListByPositions(3, 3, 2);

        CarWinnerComputer carWinnerComputer = new CarWinnerComputer(cars);
        assertThat(carWinnerComputer.isWinnerNotExist()).isFalse();
        assertThat(carWinnerComputer.getWinnerCarNameList()).hasSize(2);
        System.out.println(carWinnerComputer.getWinnerCarNameList());
        assertThat(carWinnerComputer.getWinnerCarNameList()).contains("Mommoo1", "Mommoo2");
        assertThat(carWinnerComputer.getWinnerCarNameList()).doesNotContain("Mommoo3");
    }

    private List<Car> createCarListByPositions(int ...movePositions) {
        List<Car> cars = new LinkedList<>();
        for (int index = 0 ; index < movePositions.length ; index ++) {
            String carName = "Mommoo" + (index+1);
            int movePosition = movePositions[index];
            Car car = new Car(carName, movePosition);
            cars.add(car);
        }

        return cars;
    }
}
