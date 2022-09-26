package ThirdStep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameSetting {
    private int attempts;

    private final List<Car> cars;

    public GameSetting() {
        cars = new ArrayList<>();
    }

    public int getAttempts() {
        return attempts;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setting() {
        TextPrinter.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)?");
        String[] carNames = UserInputScanner.stringScan().split(",");

        TextPrinter.print("시도할 회수는 몇 회 인가요?");
        attempts = UserInputScanner.intScan();

        setCars(carNames);
    }

    private void setCars(String[] carNames) {
        cars.addAll(Arrays.stream(carNames).map(Car::new).collect(Collectors.toList()));
    }
}
