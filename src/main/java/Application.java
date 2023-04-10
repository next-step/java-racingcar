import io.ConsoleScanner;
import io.ConsoleWriter;
import domain.Car;
import io.InputView;
import io.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final ConsoleScanner CONSOLE_SCANNER = new ConsoleScanner();
    private static final ConsoleWriter CONSOLE_WRITER = new ConsoleWriter();

    public static void main(String[] args) {
        InputView input = CONSOLE_SCANNER.input();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < input.getCarCount(); i++) {
            cars.add(new Car(input.getTryCount(), 10, 4));
        }

        CONSOLE_WRITER.writeHeader();
        for (int i = 0; i < input.getTryCount(); i++) {
            cars.forEach(Car::move);
            CONSOLE_WRITER.write(new ResultView(cars));
        }
    }
}
