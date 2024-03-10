import domain.Car;
import java.util.ArrayList;
import java.util.List;
import view.InputView;

public class RacingCarApplication {

    private final static int NUMBER_OR_CAR_INDEX = 0;
    private final static int COUNT_OF_TRIAL = 1;

    private final static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> input = InputView.requestInput();
        generateCars(input.get(NUMBER_OR_CAR_INDEX));
    }

    private static void generateCars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
    }
}
