import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarUtils {

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomUtils.generateRandomNumber(10));
            ResultView.printResultWithName(car);
        }
        ResultView.println("");
    }

    public static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public static List<Car> generateCarsWithName(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        return cars;
    }

    public static List<Car> getWinnerCars(List<Car> cars) {

        int maxDistance = cars.stream()
                                .mapToInt(Car::getDistance)
                                .max()
                                .orElse(0);

        return cars.stream()
                    .filter(io-> io.getDistance() == maxDistance)
                    .collect(Collectors.toList());
    }
}
