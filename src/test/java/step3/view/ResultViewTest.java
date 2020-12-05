package step3.view;

import step3.Car;
import step3.RandomNumberProvider;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {

    @Test
    @DisplayName("자동차 경주 결과 출력 테스트")
    void printRoundResultTest() {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        List<Car> cars = Arrays.asList(car1, car2, car3);
        for (int i = 0; i < 5; i++) {
            car1.accelerate(RandomNumberProvider.provideRandomNumber());
            car2.accelerate(RandomNumberProvider.provideRandomNumber());
            car3.accelerate(RandomNumberProvider.provideRandomNumber());

            ResultView.getRoundResult(cars, "-");
        }
    }
}
