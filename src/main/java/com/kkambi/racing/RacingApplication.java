package com.kkambi.racing;

import com.kkambi.racing.domain.Car;
import com.kkambi.racing.util.Dice;
import com.kkambi.racing.view.InputView;
import com.kkambi.racing.view.TotalView;

import java.util.ArrayList;
import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        TotalView totalView = new TotalView();
        List<Car> carList = new ArrayList<>();
        InputView.InputCommand inputCommand = totalView.getInput();

        for (int i=0; i<inputCommand.getNumberOfCars(); i++) {
            carList.add(new Car());
        }

        for (int times = 1; times <= inputCommand.getNumberOfAttempts(); times++) {
            for (Car car : carList) {
                car.tryToMove(Dice.roll(10));
            }
            totalView.printLocation(times, carList);
        }
    }
}
