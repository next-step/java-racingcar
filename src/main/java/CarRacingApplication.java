import java.util.ArrayList;
import java.util.List;
import racing.Racing;
import racing.domain.Car;
import racing.util.RandomNumberGeneratorImpl;
import racing.view.InputView;
import racing.view.ResultView;

public class CarRacingApplication {
  private static List<Car> cars = new ArrayList<>();
  private static Racing racing = new Racing();
  private static RandomNumberGeneratorImpl randomNumberGenerator = new RandomNumberGeneratorImpl();

  public static void main(String[] args) {
    int numberOfCar = InputView.requestNumberOfCar();
    int numberOfRound = InputView.requestNumberOfRound();

    generateCar(numberOfCar);

    ResultView.start();
    racing.race(cars, numberOfRound);
    ResultView.end();
  }

  private static void generateCar(int numberOfCar){
    for (int i=0; i<numberOfCar; i++){
      cars.add(new Car(randomNumberGenerator));
    }
  }
}
