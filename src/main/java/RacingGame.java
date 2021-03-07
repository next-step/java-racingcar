import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> cars;

    private static int validationArgument(String value){
        if (!GameCondition.isInteger(value)) {
            throw new IllegalArgumentException("정수 형태의 숫자만 입력이 가능합니다.");
        }
        return Integer.parseInt(value);
    }

    private List<Integer> go() {
        List<Integer> carProgresses = new ArrayList<>();
        for(Car car: cars) {
            car.advance();
            carProgresses.add(car.getNumberOfAdvance());
        }
        return carProgresses;
    }

    private void race(int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            List<Integer> result = go();
            ResultView.showRaceNumberOfTimes(result);
        }
    }

    public void start() {
        InputView inputView = new InputView();
        String value = inputView.inputIntArgument("자동차 대수는 몇 대 인가요?");
        int numberOfCars = validationArgument(value);

        value = inputView.inputIntArgument("시도할 회수는 몇 회 인가요?");
        int numberOfAttempts = validationArgument(value);

        cars = new CarFactory(numberOfCars).generateCars();

        race(numberOfAttempts);
    }
}
