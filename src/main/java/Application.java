import calculator.Calculator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Game;
import racingcar.domain.Car;
import racingcar.utils.Console;

public class Application {

    public static void main(String[] args) {
//        Calculator calc = new Calculator();
//        System.out.println("결과값은 " + calc.value() + "입니다.");

        List<String> carNames = Console.getCarNames();
        int turn = Console.getTurn();

        // Initialize Car Objects and Run Game
        List<Car> cars = carNames.stream()
            .map(carName -> new Car(carName))
            .collect(Collectors.toList());

        new Game(cars, turn).play();
    }
}
