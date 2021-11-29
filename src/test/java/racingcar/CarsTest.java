package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    private final List<Car> carList = new ArrayList<>(Arrays.asList(new Car("이름1", 1), new Car("이름2", 2), new Car("이름3", 3)));
    private final List<Car> carList2 = new ArrayList<>(Arrays.asList(new Car("이름1", 1), new Car("이름2", 2), new Car("이름3", 2)));
    private final Cars cars2 = new Cars(carList);
    private final Cars cars3 = new Cars(carList2);

    @Test
    @DisplayName("입력한 자동차 이름이 제대로 컬렉션에 저장 됐는지 테스트")
    void carNameTest() {

        String carName = "car1,car2,car3";

        Cars cars = Cars.makeRacingCarsFromName(carName);

        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars()).extracting("name").contains("car1", "car2", "car3");
    }


    @Test
    @DisplayName("입력한 자동차 이름 5글자 넘을 때 exception 발생 테스트")
    void carNameLimitTest() {

        String carName = "car1,car1234,car3";

        InputStream in = new ByteArrayInputStream(carName.getBytes());
        System.setIn(in);
        String res = InputView.getInput("자동차 이름 입력");

        assertThatThrownBy(() -> Cars.makeRacingCarsFromName(res)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5 characters");

    }

    @Test
    @DisplayName("우승자가 맞는지 테스트")
    void winnerTest() {

        List<Car> list = cars2.getWinnerCar();

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getName()).isEqualTo("이름3");
    }

    @Test
    @DisplayName("우승자가 여러명일때 맞는지 테스트")
    void winnerTest2() {

        List<Car> list = cars3.getWinnerCar();

        assertThat(list.size()).isEqualTo(2);
        assertThat(list).extracting("name").contains("이름3", "이름2");
    }

}
