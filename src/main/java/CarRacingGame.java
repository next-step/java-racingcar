import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final int RANDOM_NUMBER = 10;
    private RandomUtil randomUtil = new RandomUtil();
    private List<Car> cars = new ArrayList<>();

    public  void start() {
        int carNumber = InputView.carInput();
        int tryNumber = InputView.tryInput();

        for(int i=0; i<carNumber; i++) {
            cars.add(new Car());
        }
        ResultView.printResultStartMessage();
        for (int i=0; i<tryNumber; i++) {
            forward();
            System.out.println();
        }

    }
    public void forward() {
        for(Car car : cars) {
            car.addPosition(this.randomUtil.randomCount(RANDOM_NUMBER));
        }
        ResultView.printResult(cars);
    }
}
