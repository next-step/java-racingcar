package new_racingcar.domain;

import new_racingcar.domain.Car;
import new_racingcar.domain.Cars;
import new_racingcar.strategy.MoveOneStrategy;
import new_racingcar.strategy.MoveStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Car 테스트")
class CarTest {
    private MoveStrategy moveStrategy;

    @BeforeEach
    public void setUp() {
        this.moveStrategy = new MoveOneStrategy();
    }

    public Car setCar(String name) {
        return new Car(name, moveStrategy);
    }

    @ParameterizedTest
    @ValueSource(strings = {"povi", "1234", "12345", "1"})
    @DisplayName("자동차 이름 5글자 이하만 허용")
    public void carNameLength5DownTest(String name) throws Exception {
        //given

        //when

        //then
        setCar(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"povi123", "1231234", "12312345"})
    @DisplayName("자동차 이름 5글자 초과 에러 발생")
    public void carNameLength5UpErrorTest(String name) throws Exception {
        //given

        //when,then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            setCar(name);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름 공백 시 에러 발생")
    public void carNameLength0ErrorTest(String name) throws Exception {
        //given
        List<String> names = Arrays.asList(",,,,,".split(","));

        //when,then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            setCar(name);
        });
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