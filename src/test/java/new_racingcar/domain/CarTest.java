package new_racingcar.domain;

import new_racingcar.domain.Car;
import new_racingcar.domain.Cars;
import new_racingcar.strategy.MoveOneStrategy;
import new_racingcar.strategy.MoveStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Car 테스트")
class CarTest {
    private MoveStrategy moveStrategy;

    @BeforeEach
    public void setUp() {
        this.moveStrategy = new MoveOneStrategy();
    }

    @Test
    @DisplayName("읽기전용 cars 사용 시 에러 확인")
    public void readOnlyCarTest() throws Exception {
        //given
        String inputName = "pobi,crong,honux";
        List<String> names = Arrays.asList(inputName.split(","));

        //when
        Cars cars = new Cars(names, new MoveOneStrategy());
        List<Car> carList = cars.getUnmodifiableCars();

        //then
        assertThrows(Exception.class, () -> {
            carList.add(new Car("name", new MoveOneStrategy()));
        });
    }
}