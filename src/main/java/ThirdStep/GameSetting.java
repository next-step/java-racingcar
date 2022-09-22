package ThirdStep;

import java.util.ArrayList;
import java.util.List;

public class GameSetting {
    private int carCount;
    private int attempts;

    private final List<Car> cars;

    public GameSetting() {
        cars = new ArrayList<>();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getAttempts() {
        return attempts;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setting() {
        TextPrinter.print("자동차 대수는 몇 대 인가요?");
        carCount = UserInputScanner.intScan();

        TextPrinter.print("시도할 회수는 몇 회 인가요?");
        attempts = UserInputScanner.intScan();

        setCars();
    }

    private void setCars() {
        for (int count = 0 ; count < this.getCarCount() ; ++count) {
            cars.add(new Car());
        }
    }
}
