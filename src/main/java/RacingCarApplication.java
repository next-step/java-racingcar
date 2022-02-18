import java.util.ArrayList;
import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        String carNameInput = ConsoleScanner.getInputCarNames();
        String[] carNames = carNameInput.split(",");

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
