package study.step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step5.domain.Car;
import study.step5.domain.Round;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    private List<Car> cars;

    @BeforeEach
    void setUp(){
        cars = new ArrayList<>();
        cars.add(new Car("자동차1"));
        cars.add(new Car("자동차2"));
        cars.add(new Car("자동차3"));
        cars.add(new Car("자동차4"));
        cars.add(new Car("자동차5"));
    }

    @Test
    @DisplayName("차 이름 비어있을 경우 예외 발생하는지 테스트")
    void carNamesValidateTest(){
        String [] carNames = {"", " "};
        assertThatThrownBy(() ->
            new Round(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("차 전진조건 충족했을때 다 전진했는지 테스트")
    @ValueSource(ints = {0,1,2,3,4})
    void carsRunTest(int index){
        List<Car> arrivedCars = new Round(cars).carsRun(new MockRandomCarMoveCondition(5)).getCars();
        assertThat(arrivedCars.get(index).getCarPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("차 전진조건 미충족했을때 다 멈춰있었는지 테스트")
    @ValueSource(ints = {0,1,2,3,4})
    void carsDoNotRunTest(int index){
        List<Car> arrivedCars = new Round(cars).carsRun(new MockRandomCarMoveCondition(3)).getCars();
        assertThat(arrivedCars.get(index).getCarPosition()).isEqualTo(0);
    }
}
