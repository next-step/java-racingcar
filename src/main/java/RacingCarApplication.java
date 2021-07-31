import java.util.ArrayList;
import java.util.List;
import racingCar.domain.NumberGenerator;
import racingCar.domain.RacingCar;
import racingCar.domain.RandomNumberGenerator;
import racingCar.ui.InputService;
import racingCar.ui.PrintService;

public class RacingCarApplication {

    public static void main(String[] args) {
        int numberOfCar, tryCount;

        numberOfCar = InputService.getNumberOfCar();
        tryCount = InputService.getTryCount();

        List<RacingCar> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new RacingCar());

        }

        System.out.println("실행결과");

        for (int i = 0; i < tryCount; i++) {
            runGame(cars);
            System.out.println();
        }
    }

    public static void runGame(List<RacingCar> cars) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        for (int j = 0; j < cars.size(); j++) {
            cars.get(j).goForward(numberGenerator.getNumber());
            PrintService.printDistance(cars.get(j).showDrivenDistance());
        }
    }
}
