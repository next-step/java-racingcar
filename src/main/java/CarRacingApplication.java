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
    String[] numberOfCar = InputView.requestCarWithName();
    int numberOfRound = InputView.requestNumberOfRound();

    generateCarWithName(numberOfCar);

    ResultView.start();
    racing.race(cars, numberOfRound);
    ResultView.end();
  }

  private static void generateCar(int numberOfCar){
    for (int i=0; i<numberOfCar; i++){
      cars.add(new Car(randomNumberGenerator, String.valueOf(i)));
    }
  }
  private static void generateCarWithName(String[] names){
    for (int i=0; i<names.length; i++){
      cars.add(new Car(randomNumberGenerator, names[i]));
    }
  }
}
