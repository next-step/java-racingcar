package core;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RacingGame {

    static List<Car> carList;

    RacingGame() {
        carList = new ArrayList<>();
        IntStream.range(0,InputView.carCount).forEach(i -> carList.add(new Car()));
    }

    void startGame() {
        IntStream.range(0,InputView.round).forEach(i -> startRound());
    }

    void startRound() {
        for(Car car : carList) {
            int randNum = new Random().nextInt(10);

            car.addResult(compareRandNum(randNum));
            ResultView.printOutputValue(car.roundResult.stream());
        }
    }

    public static String compareRandNum(int randNum) {
        if(randNum >= 4) {
            return new MoveAction().carAction();
        }
        return new StopAction().carAction();
    }


}


