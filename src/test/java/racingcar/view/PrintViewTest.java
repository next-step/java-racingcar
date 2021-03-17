package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class PrintViewTest {

    @DisplayName("carToStatus 는 자동차 이름을 같이 출력한다.")
    @Test
    void carToStatus_startWithCarName() {
        String name = "car";
        Car car = new Car(name);
        PrintView printView = new PrintView();
        String carStatus = printView.carToStatus(car);

        assertThat(carStatus).startsWith(name);
    }

    @DisplayName("carToStatus 는 전진 횟수만큼 \"-\"를 출력한다. ")
    @Test
    void carToStatus() {
        String name = "car";
        Car car = new Car(name);
        car.moveOrStay(Car.THRESHOLD);
        car.moveOrStay(Car.THRESHOLD);
        car.moveOrStay(Car.THRESHOLD);
        PrintView printView = new PrintView();

        String carStatus = printView.carToStatus(car);

        assertThat(carStatus).contains("---");
    }
}
