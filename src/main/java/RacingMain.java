import domain.Car;
import domain.Cars;
import domain.Race;
import util.CommonUtil;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String carNames = inputView.getCarNames();
        int numOfRounds = inputView.getNumberOfRounds();

        List<Car> cars = prepareRace(carNames, numOfRounds);
        resultView.printFinalResult(Race.getWinner(cars));
    }

    public static List<Car> prepareRace(String carNames, int numOfRounds) {
        List<Car> cars = Cars.create(carNames);
        Race race = new Race(cars, numOfRounds);

        for (int i = 0; i < race.getTurns(); i++) {
            beginTurn(cars);
            System.out.println();
        }
        return cars;
    }

    public static void beginTurn(List<Car> cars) {
        for (Car car : cars) {
            getEachTurn(car);
        }
    }

    public static void getEachTurn(Car car) {
        if (CommonUtil.getRandomNumber() > 6) {
            car.getSteps().append("-");
            car.addForward();
        }
        ResultView.printEachCarResult(car);
    }
}
