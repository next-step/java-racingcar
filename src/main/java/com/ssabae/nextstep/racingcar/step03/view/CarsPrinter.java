package com.ssabae.nextstep.racingcar.step03.view;

import com.ssabae.nextstep.racingcar.step03.domain.Car;
import com.ssabae.nextstep.racingcar.step03.domain.Cars;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-07
 */
public class CarsPrinter {

    public void print(Cars cars) {
        List<Car> carList = cars.getCarList();
        carList.forEach(this::printCar);
        System.out.println();
    }

    private void printCar(Car car) {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s : ", car.getName()));
        for (int i = 0; i < car.getMoveCount(); i++) {
            output.append("-");
        }
        System.out.println(output.toString());
    }

    public void printWinner(Cars cars) {
        String names = cars.getWinnerNames();
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
