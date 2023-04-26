package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {


    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("조건 값에 따른 True, False 반환 확인")
    void check_go_or_stop_when_condition_is_four(int randomNumber, boolean expected) {
        Car car = new Car();
        assertThat(car.goOrStop(4, randomNumber)).isEqualTo(expected);
    }


    @Test
    @DisplayName("위치 값이 1씩 증가 확인")
    void check_position_value_plus_one(){
        Car car = new Car();
        car.plugPosition();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car 추가시 이름 입력")
    void add_new_car_with_name(){
        Car car = new Car("test");

        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("조건 값에 따른 True, False 반환 확인")
    void check_move_when_value_over_the_condition_four() {
        Car car = new Car();
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("조건 값에 따른 True, False 반환 확인")
    void check_move_when_value_under_the_condition_four() {
        Car car = new Car();
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }


    @Test
    @DisplayName("Car 이름이 5자 초과시 exception 발생")
    void expected_exception_when_name_length_over_five(){
        assertThatThrownBy(()->{
            Car car = new Car("test11");
        }).isInstanceOf(RuntimeException.class)
                .hasMessage(Car.NAME_LENGTH_EXCEPTION_MESSAGE);
    }


    @Test
    @DisplayName("Car 위치값중 가장 큰 값을 찾는다.")
    void extract_max_value_of_position_from_cars(){
        Cars cars = new Cars();

        cars.addCar("car1");
        cars.addCar("car2");
        cars.addCar("car3");

        cars.getCar().get(0).plugPosition();
        cars.getCar().get(0).plugPosition();

        assertThat(cars.getMaxPosition(1, cars.getCar().get(0))).isEqualTo(2);
        assertThat(cars.getMaxPosition(3, cars.getCar().get(0))).isEqualTo(3);
    }
}