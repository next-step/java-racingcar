import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static void main(String[] args) {

//        int carCount = InputView.getAnswerToInteger(Messages.ASK_CAR_COUNT);

        ResultView.askCarNames();

        String[] carNames = InputView.getCarNames();

        List<Car> cars = generateCarsWithName(carNames);

        ResultView.askTryTimes();

        int tryTimes = InputView.getAnswerToInteger();

        ResultView.printResult();

        for (int j = 0; j < tryTimes; j++) {
            moveCars(cars);
        }

        ResultView.printWinner(cars);

    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomUtils.generateRandomNumber(10));
            ResultView.printResultWithName(car);
        }
        ResultView.println("");
    }

    private static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private static List<Car> generateCarsWithName(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        return cars;
    }
}