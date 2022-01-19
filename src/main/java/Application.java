import calculator.Calculator;
import java.util.ArrayList;
import java.util.List;
import racingcar.Game;
import racingcar.domain.Car;
import racingcar.utils.Console;

public class Application {

    public static void main(String[] args) {
//        Calculator calc = new Calculator();
//        System.out.println("결과값은 " + calc.value() + "입니다.");

        List<String> carNames = Console.getCarNames();
        int carCount = carNames.size();
        int turn = Console.getTurn();

        // Initialize Car Objects and Run Game
        List<Car> cars = new ArrayList<>();
        for (int index = 0; index < carCount; index++) {
            cars.add(new Car(carNames.get(index)));
        }

        new Game(cars, turn).play();
    }
}
