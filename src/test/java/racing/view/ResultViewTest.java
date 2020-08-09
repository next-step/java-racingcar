package racing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Car;

class ResultViewTest {

    @Test
    @DisplayName("자동차 상태를 출력한다")
    public void print() {
        // given
        Car[] cars = new Car[3];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(1);
            cars[i] = new Car(2);
            cars[i] = new Car(3);
        }

        // then
        ResultView.print(cars);

    }

}
