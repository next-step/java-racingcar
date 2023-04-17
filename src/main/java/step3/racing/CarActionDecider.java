package step3.racing;

import java.util.function.Consumer;

/**
 * @author : 0giri
 * @since : 2023/04/17
 */
public class CarActionDecider {

    public static Consumer<Car> action(int number) {
        validIsNotNegative(number);
        if (passMoveRule(number)) {
            return moveAction(number);
        }
        return stopAction();
    }

    private static void validIsNotNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private static boolean passMoveRule(int number) {
        return 4 <= number;
    }

    private static Consumer<Car> moveAction(int number) {
        return car -> car.move(number);
    }

    private static Consumer<Car> stopAction() {
        return Car::stop;
    }
}
