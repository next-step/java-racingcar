package racing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @Test
    @DisplayName("자동차는 이름을 가질 수 있다.")
    void carHaveName() {
        Car car = new Car("lucas");

        String actual = car.getName();

        assertThat(actual).isEqualTo("lucas");
    }

    @Test
    @DisplayName("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.")
    void vaildNameTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Car car = new Car("llllcas");
                }
                ).withMessageContaining("5자를 초과");
    }

    @Test
    @DisplayName("차 초기 위치는 0")
    void carDefaultPosition() {

        Car car = new Car("lucas");

        int actual = car.getPosition();

        int defaultPosition = 0;

        assertEquals(actual, defaultPosition);
    }

    @Test
    @DisplayName("자동차의 현재 위치를 알 수 있다.")
    void getCarPosition(){

        int testPosition = 4;
        Car car = new Car("lucas", testPosition);

        int actual = car.getPosition();

        assertEquals(actual, testPosition);

    }


    @DisplayName("4 이상이면 자동차가 이동한다.")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void moveCar(int value){

        Car car = new Car("lucas");

        assertThat(car.move(value));
    }

    @DisplayName("4 미만이면 자동차는 정지한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void stopCar(int value){
        Car car = new Car("lucas");

        assertThat(!car.move(value));
    }

    @DisplayName("moveOption에 따라 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource({
            "1, false",
            "2, false",
            "3, false",
            "4, true",
            "5, true"
    })
    void moveTest(final int moveOption, boolean expect) {
        Car car = new Car("lucas");

        assertEquals(car.move(moveOption), expect);
    }
}

