package fifth_refactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarActionTest{
    private String systemInStringValue = "";

    @Test
    void moveTest(){
        Car car = new Car("test");
        car.move();
        assertThat(car.getCarPosition()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource( strings = {"pobi,crong,honux"} )
    @DisplayName("자동차 입력값 테스트")
    void carNameInputTest(String testInput) {
        String carName = "pobi";
        System.setIn(new ByteArrayInputStream(systemInStringValue.getBytes()));
        String[] splitCarName =
                CarAction.splitCarName(testInput);
        assertThat(splitCarName[0]).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 초기 세팅 객체테스트")
    void setCarTest(){
        String[] testInput = {"pobi", "crong", "honux"};
        System.setIn(new ByteArrayInputStream(systemInStringValue.getBytes()));
        List<Car> car = CarAction.setCar(testInput);
        assertThat(car.get(0).getCarName()).isEqualTo("pobi");
        assertThat(car.get(0).getCarPosition()).isEqualTo(1);
    }
}
