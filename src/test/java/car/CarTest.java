package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    List<Car> cars;
    @BeforeEach
    void setUp(){

        Car car = new Car("test1");
        Car car1 = new Car("test2");
        cars = new ArrayList<>();

        car.move(car.stopMoveStrategy());
        cars.add(car);

        car1.move(car1.goMoveStrategy());
        cars.add(car1);
    }

    private InputView inputView = new InputView();
    @Test
    @DisplayName("4이상 랜덤값 1 반환 테스트")
    public void test1(){
        Car car = new Car();
        car.move(car.goMoveStrategy());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만 랜덤값 0 반환 테스트")
    public void test2(){
        Car car = new Car();
        car.move(car.stopMoveStrategy());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("car 객체 position 상태값 변경테스트")
    public void test3(){
        Car car = new Car();

        int result = 0;
        for (int i = 0; i < 3; i++) {
            car.move(car.goMoveStrategy());
            result = car.getPosition();
        }
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 ,로분리하기")
    public void test4(){
        InputView inputView1 = new InputView();
        String[] result = inputView.carAttendNameSeparation("car1,car2");
        assertThat(result[0]).isEqualTo("car1");
        assertThat(result[1]).isEqualTo("car2");
    }

    @Test
    @DisplayName("Car객체 name 설정")
    public void test5(){
        Car car = new Car("car");
        assertThat(car.getName()).isEqualTo("car");
    }

    @Test
    @DisplayName("자동차명이 5자를 초과할 경우")
    public void test6(){
        assertThatThrownBy(() ->assertThat(inputView.carNameCheck("carTest")))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차명이 5자이하인경우 ")
    public void test7(){
        assertThat(inputView.carNameCheck("test1"))
                .isEqualTo("test1");
    }
    @Test
    @DisplayName("Car 객체들의 position값 중 가장 큰 값을 반환하는지")
    public void test8(){
        RacingResult racingResult = new RacingResult(cars);
        assertThat(racingResult.getMax()).isEqualTo(1);
    }

    @Test
    @DisplayName("test2 객체 우승")
    public void test9(){
        RacingResult racingResult = new RacingResult(cars);
        assertThat(racingResult.getWinnerCars().get(0)).isEqualTo(cars.get(1));

    }
}
