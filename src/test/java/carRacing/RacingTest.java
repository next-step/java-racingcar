package carRacing;

import car.Car;
import carRacing.view.InputView;

import carRacing.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("원하는 숫자만큼 입력부 세팅시 정상적으로 값이 설정되는지 확인")
    @Test
    void inputView_Test() {

        systemIn("3\n5");
        InputView inputView = new InputView();
        assertThat(inputView.getCarCount()).isEqualTo(3);
        assertThat(inputView.getMoveCount()).isEqualTo(5);
    }

    @DisplayName("실행결과와 각 차량의 현재 위치를 제대로 보여주는지 확인")
    @Test
    void resultView_Test() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        for (Car car : cars) {
            car.move(5);
        }

        System.out.println("cars = " + cars);   //객체가 3개로 정상적으로 생성되었는지 확인( 예: [car.Car@446293d, car.Car@69997e9d, car.Car@793be5ca] )

        ResultView resultView = new ResultView(cars);
        System.out.println("###########################");  //테스트 확인을 위한 Text
        resultView.show();
        System.out.println("###########################");
    }

    @DisplayName("차량 3대를 5회 이동시켰을때 결과")
    @Test
    void racingTest() {

        systemIn("3\n5");   //3대 5회
        InputView inputView = new InputView();

        Racing racing = new Racing(inputView);
        racing.startRacingCar();
    }


    /**
     * System.in을 하기위한 method
     *
     * @param input
     */
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }

}
