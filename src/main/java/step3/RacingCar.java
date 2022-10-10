package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private static final Random random = new Random();
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static List<Car> winner = new ArrayList<>();

    public static void main(String[] args) {
        List<Car> carList = inputView.carNames();
        int carRunningNumber = inputView.carRunningNumber();
        resultView.startView();
        for(int i = 0; i < carRunningNumber; i++) {
            advanceCar(carList);
        }
        finalWinner(carList);
    }

    private static void advanceCar(List<Car> cars) {
        for (Car car : cars) {
            Position position = car.advanceCar(random.nextInt(10));
            resultView.resultView(car.currentName(), position);
        }
        System.out.println();
    }

    private static void finalWinner(List<Car> cars) {
        for(int i = 0; i < cars.size(); i++) {
            compare(cars.get(i), i);
        }
        resultView.winnerView(winner);

    }

    private static void compare(Car car, int index) {
        if(index == 0) {
            winner.add(car);
            return;
        }
        if(car.currentPosition().compare(winner.get(winner.size()-1).currentPosition()).equals("bigger")) {
            winner.clear();
            winner.add(car);
            return;
        };
        if(car.currentPosition().compare(winner.get(winner.size()-1).currentPosition()).equals("equals")) {
            winner.add(car);
            return;
        };
    }


}
