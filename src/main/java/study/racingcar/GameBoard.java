package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {

    private InputView inputView;
    private OutputView outputView;

    public GameBoard() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Random random = new Random();

        outputView.printCarNumber();

        final int carNum = inputView.getCarNumber();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }

        outputView.printTryCountSign();
        final int tryCount = inputView.getTryCount();


        outputView.printResultSign();


        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                int randomValue = random.nextInt(10);
                if (randomValue >= 4) {
                    car.setMoveCount(car.getMoveCount() + 1);
                }
                System.out.println("-".repeat(car.getMoveCount()));
            }
            System.out.println();
        }

    }
}
