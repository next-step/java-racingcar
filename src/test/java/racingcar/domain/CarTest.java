package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("차가 잘 움직였는가를 확인")
    @Test
    public void playWithMove() {
        Car car = new Car("name", 0);
        MoveChecker moveChecker = new TrueMoveChecker();

        car.play(moveChecker);
        ResultCar resultCar = car.getResult();

        assertThat(resultCar.getLocation()).isEqualTo(1);
    }

    @DisplayName("차가 움직이지 않았는가를 확인")
    @Test
    public void playWithoutMove() {
        Car car = new Car("name", 0);
        MoveChecker moveChecker = new FalseMoveChecker();

        car.play(moveChecker);
        ResultCar resultCar = car.getResult();

        assertThat(resultCar.getLocation()).isEqualTo(0);
    }

    @DisplayName("차의 현재 거리보다 더 먼거리와 비교하였을때 먼거리를 반환하는지 확인")
    @Test
    public void getMaxLocationReturnInputLocation() {
        Car car = new Car("name", 3);

        assertThat(car.getMaxLocation(5)).isEqualTo(5);
    }

    @DisplayName("차의 현재 거리보다 더 짧은 거리와 비교하였을때 차의 현재 거리를 반환하는지 확인")
    @Test
    public void getMaxLocationReturnCarLocation() {
        Car car = new Car("name", 5);

        assertThat(car.getMaxLocation(3)).isEqualTo(5);
    }

    @DisplayName("차의 현재 거리와 같은 값이 들어왔을때 차 이름이 리스트에 잘 더해지는지 확인")
    @Test
    public void addCarNameIfEqualLocationWithEqualLocation() {
        Car car = new Car("name", 5);
        List<String> list = new ArrayList<>();

        car.addCarNameIfEqualLocation(list, 5);

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo("name");
    }

    @DisplayName("차의 현재 거리와 다른 값이 들어왔을때 차 이름이 리스트에 안 더해지는지 확인")
    @Test
    public void addCarNameIfEqualLocationWithUnequalLocation() {
        Car car = new Car("name", 5);
        List<String> list = new ArrayList<>();

        car.addCarNameIfEqualLocation(list, 3);

        assertThat(list.size()).isEqualTo(0);
    }
}

