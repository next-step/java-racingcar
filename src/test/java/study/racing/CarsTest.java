package study.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racing.domain.Car;
import study.racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;
    private int carCnt;

    @BeforeEach
    void setUp(){
        carCnt = 1;
        cars = new Cars(new String[]{"A"});

    }

    @DisplayName("Cars 생성자 테스트")
    @Test
    void carsConstructTest(){
        int carSetSize = cars.getCarSet().size();
        assertThat(carSetSize).isEqualTo(carCnt);
    }

    @DisplayName("Car 생성 테스트")
    @Test
    void carsCreateTest(){
        // given
        String[] names = {"AAA", "BBB", "CCC"};

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars.getCarSet().size()).isEqualTo(3);
        assertThat(cars.getCarSet()).containsExactly(new Car("AAA"), new Car("BBB"), new Car("CCC"));
    }

    @DisplayName("Cars Move 메소드 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4})
    void carsMoveTest(int expectedPosition){
        cars.move(() -> expectedPosition);

        List<Integer> positionList = new ArrayList<>();
        cars.getCarSet().stream()
                .forEach(car -> positionList.add(car.getPosition()));

        positionList.stream()
                .forEach(position -> assertThat(position).isEqualTo(expectedPosition));

    }
}
