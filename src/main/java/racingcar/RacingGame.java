package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputView.getCarNumber(); i++) {
            cars.add(new Car());
        }
        gameStart(cars, inputView.getRound());
    }

    public static void gameStart(List<Car> cars, int round) {
        System.out.println(Constants.RESULT_MESSAGE);
        ResultView resultView = new ResultView();

        for (int i = 0; i < round; i++) {
            cars.forEach(car -> {
                if (isMove()) {
                    car.movePosition();
                }
                resultView.printResult(car.getPosition());
            });
            System.out.println();
        }
    }

    private static boolean isMove() {
        return getRandomNumber() >= Constants.MOVE_CONDITION;
    }

    private static int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(10);
    }

}
