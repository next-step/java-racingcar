package step5.racing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import step5.racing.controller.Game;
import step5.racing.domain.CarName;
import step5.racing.domain.CarNames;
import step5.racing.domain.TryCount;
import step5.racing.view.InputView;

public class Application {

    private static final String CAR_NAME_SPLIT_DELIMITER = ",";

    public static void main(String[] args) {
        CarNames carNames = repeatUntilReadValidInput(Application::readCarNames);
        TryCount tryCount = repeatUntilReadValidInput(Application::readTryCount);

        Game game = new Game(carNames, tryCount);
        game.race();
    }

    private static CarNames readCarNames() {
        String input = InputView.readCarNames();

        List<CarName> carNames = Arrays.stream(input.split(CAR_NAME_SPLIT_DELIMITER))
                .map(CarName::new)
                .toList();
        return new CarNames(carNames);
    }

    private static TryCount readTryCount() {
        return new TryCount(InputView.readTryCount());
    }

    private static <T> T repeatUntilReadValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());;
            }
        }
    }
}
