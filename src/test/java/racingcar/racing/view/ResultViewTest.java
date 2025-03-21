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
    public void printStatus() {
        ResultView resultView = new ResultView();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("a");
        car1.move();
        cars.add(car1);

        Car car2 = new Car("abc");
        car2.move();
        car2.move();
        cars.add(car2);

        Car car3 = new Car("abcde");
        car3.move();
        car3.move();
        car3.move();
        cars.add(car3);

        resultView.printGameStatus(cars, 1);

        Assertions.assertThat(output.toString()).isEqualTo("stage: 1\na     : -\nabc   : --\nabcde : ---\n\n");
        System.setOut(System.out);
    }

    @DisplayName("결과 출력 테스트")
    @Test
    public void printResult() {
        ResultView resultView = new ResultView();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        resultView.printResult(List.of("name1, name2"));
        Assertions.assertThat(output.toString()).isEqualTo("name1, name2가 최종 우승했습니다.\n");

        System.setOut(System.out);
    }

}