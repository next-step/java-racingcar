package study.race;

import study.race.view.InputView;
import study.race.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        String[] names = InputView.scanNameOfCar().split(",");
        int racingCount = InputView.scanNumberOfCount();

        List<Car> cars = Racing.carArray(names);
        List<Car> result = Racing.racing(racingCount, cars);
        ResultView.resultViewWinner(Winners.findWinner(result));
    }

}


