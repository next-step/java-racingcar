package racing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import java.util.Arrays;
import java.util.List;

@DisplayName("3단계 - 자동차 경주 - CliOutputView 단위 테스트")
class CliOutputViewTest {

    @Test
    @DisplayName("자동차 상태 출력 기능")
    void printCars() {
        List<Car> cars = Arrays.asList(new Car(), new Car());
        int numberOfMove = 3;

        CliOutputView.printStartSentence();
        for (int i = 0; i < numberOfMove; i++) {
            cars.forEach(Car::moveRandom);
            CliOutputView.printCars(cars);
        }
    }
}