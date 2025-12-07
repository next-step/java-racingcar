package racing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import racing.controller.Game;
import racing.domain.CarName;
import racing.domain.TryCount;
import racing.view.InputView;

public class Application {

    private static final String CAR_NAME_DELIMITER = ",";

    public static void main(String[] args) {
        List<CarName> carNames = repeatUntilReadValidInput(Application::readCarNames);
        TryCount tryCount = repeatUntilReadValidInput(Application::readTryCount);

        Game game = new Game(carNames, tryCount);
        game.race();
    }

    private static List<CarName> readCarNames() {
        String inputNames = InputView.readCarNames();

        return Arrays.stream(inputNames.split(CAR_NAME_DELIMITER))
                .map(CarName::new)
                .toList();
    }

    private static TryCount readTryCount() {
        int tryCount = InputView.readTryCount();
        return new TryCount(tryCount);
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
