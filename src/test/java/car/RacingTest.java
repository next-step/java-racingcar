package car;

import car.domain.Car;
import car.domain.Movable;
import car.domain.RacingResult;
import car.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    Random random = new Random();
    private Movable goMove = () -> {return random.nextInt(6)+4;};
    private Movable stopMove = () -> {return random.nextInt(4);};
    List<Car> cars;
    InputView inputView = new InputView();
    @BeforeEach
    void setUp(){

        Car car = new Car("test1");
        Car car1 = new Car("test2");
        cars = new ArrayList<>();

        car.move(stopMove);
        cars.add(car);

        car1.move(goMove);
        cars.add(car1);
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
        assertThatThrownBy(() ->assertThat(new Car("test1234")))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차명이 5자이하인경우 ")
    public void test7(){
        assertThat(new Car("test1").getName())
                .isEqualTo("test1");
    }
    @Test
    @DisplayName("Car 객체들의 position값 중 가장 큰 값을 반환하는지")
    public void test8(){
        RacingResult racingResult = new RacingResult(cars);
        assertThat(racingResult.getWinnerCars().get(0).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("test2 객체 우승")
    public void test9(){
        RacingResult racingResult = new RacingResult(cars);
        assertThat(racingResult.getWinnerCars().get(0)).isEqualTo(cars.get(1));
    }
}
