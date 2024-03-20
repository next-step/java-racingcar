import java.util.ArrayList;
import java.util.List;
import racing.Racing;
import racing.domain.Car;
import racing.domain.Cars;
import racing.util.RandomNumberGeneratorImpl;
import racing.view.InputView;
import racing.view.ResultView;

public class CarRacingApplication {

    private static Cars cars;
    private static Racing racing = new Racing();
    private static RandomNumberGeneratorImpl randomNumberGenerator = new RandomNumberGeneratorImpl();

    public static void main(String[] args) {
        String[] numberOfCar = InputView.requestCarWithName();
        int numberOfRound = InputView.requestNumberOfRound();

        generateCarWithName(numberOfCar);

        ResultView.start();
        racing.race(cars.getCars(), numberOfRound);
        ResultView.end();

        ResultView.showWinner(cars);
    }

    private static void generateCar(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car(randomNumberGenerator, String.valueOf(i)));
        }
    }

    private static void generateCarWithName(String[] names) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            carList.add(new Car(randomNumberGenerator, names[i]));
        }
        cars = new Cars(carList);
    }
}
