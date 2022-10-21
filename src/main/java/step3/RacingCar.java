package step3;

import java.util.List;
import java.util.Random;
import step3.domain.Car;
import step3.domain.Position;
import step3.domain.Winners;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingCar {

    private static final Random random = new Random();
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

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
        List<Car> winners = Winners.findWinners(cars);
        resultView.winnerView(winners);

    }
}
