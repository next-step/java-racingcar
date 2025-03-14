package racingcar.racing.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racing.model.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class ResultViewTest {
    @DisplayName("결과 출력 테스트")
    @Test
    public void print() {
        ResultView resultView = new ResultView();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        car1.move();
        cars.add(car1);

        Car car2 = new Car();
        car2.move();
        car2.move();
        cars.add(car2);

        Car car3 = new Car();
        car3.move();
        car3.move();
        car3.move();
        cars.add(car3);

        resultView.view(cars);

        Assertions.assertThat(output.toString()).isEqualTo("-\n--\n---\n");
        System.setOut(System.out);
    }

}