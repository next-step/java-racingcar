package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private final CarService carService = new CarService();
    private final List<Car> cars = new ArrayList<>(Arrays.asList(new Car("이름1", 1), new Car("이름2", 2), new Car("이름3", 3)));
    private final List<Car> cars2 = new ArrayList<>(Arrays.asList(new Car("이름1", 1), new Car("이름2", 2), new Car("이름3", 2)));

    @Test
    @DisplayName("자동차 이동 후 위치가 최대 1만 이동했는지 테스트")
    void carMoveLocationTest() {
        int firstLocation = 2;
        Car car = new Car("이름1", firstLocation);

        assertThat(car.move().getLocation()).isBetween(firstLocation, firstLocation + 1);
    }

    @Test
    @DisplayName("Racing 후 car 컬렉션 상태 체크")
    void carNumberTest() {

        Racing racing = new Racing(cars);

        List<Car> carList = racing.doRacing();

        carList.forEach(car -> assertThat(car.getLocation()).isBetween(0, 1));
    }

    @Test
    @DisplayName("입력한 자동차 이름이 제대로 컬렉션에 저장 됐는지 테스트")
    void carNameTest() {

        String carName = "car1,car2,car3";

        InputStream in = new ByteArrayInputStream(carName.getBytes());
        System.setIn(in);
        String res = InputView.getInput("자동차 이름 입력");


        List<Car> list = CarService.makeRacingCarsFromName(res);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list).extracting("name").contains("car1", "car2", "car3");
    }

    @Test
    @DisplayName("우승자가 맞는지 테스트")
    void winnerTest() {

        List<Car> list = carService.getWinnerCar(cars);

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getName()).isEqualTo("이름3");
    }

    @Test
    @DisplayName("우승자가 여러명일때 맞는지 테스트")
    void winnerTest2() {

        List<Car> list = carService.getWinnerCar(cars2);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list).extracting("name").contains("이름3", "이름2");
    }

}
