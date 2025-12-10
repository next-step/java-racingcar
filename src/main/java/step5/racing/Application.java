package step5.racing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import step5.racing.domain.CarName;
import step5.racing.domain.TryCount;
import step5.racing.view.InputView;

public class Application {

    private static final String CAR_NAME_SPLIT_DELIMITER = ",";

    public static void main(String[] args) {
        List<CarName> carNames = repeatUntilReadValidInput(Application::readCarNames);
        TryCount tryCount = repeatUntilReadValidInput(Application::readTryCount);
    }

    private static List<CarName> readCarNames() {
        String input = InputView.readCarNames();

        return Arrays.stream(input.split(CAR_NAME_SPLIT_DELIMITER))
                .map(CarName::new)
                .toList();
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
