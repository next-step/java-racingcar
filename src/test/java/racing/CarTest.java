package racing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    @DisplayName("자동차는 이름을 가질 수 있다.")
    void carHaveName() {
        Car car = new Car("BMW");

        String actual = car.getName();

        assertThat(actual).isEqualTo("BMW");
    }

    @Test
    @DisplayName("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.")
    void checkNameTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                            Car car = new Car("BMW155");
                        }
                ).withMessageContaining("차이름은 5글자 미만이여야 합니다.");
    }

    @Test
    @DisplayName("차 위치 초기값은 0")
    void carDefaultPosition() {

        Car car = new Car("BMW");

        int actual = car.getPosition();

        assertEquals(actual, 0);
    }

    @Test
    @DisplayName("자동차의 현재 위치를 알 수 있다.")
    void getCarPosition(){
        Car car = new Car("BMW");
        int actual = car.getPosition();
        assertEquals(actual, 0);
    }


    @DisplayName("4 이상이면 자동차가 이동한다.")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void moveTest(int value){
        Car car = new Car("BMW");
        int actual = car.move(5);
        assertEquals(actual, 1);
    }

    @DisplayName("4 미만이면 자동차는 정지한다.")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void stopCar(int value){
        Car car = new Car("BMW");
        int actual = car.move(3);
        assertEquals(actual, 0);
    }

    @DisplayName("moveOption에 따라 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1"
    })
    void moveTest(final int moveOption, int expect) {
        Car car = new Car("BMW");
        int actaul = car.move(moveOption);
        assertEquals(actaul, expect);
    }

    @Test
    @DisplayName("현재위치 포맷에 따라 잘 나오는지 검증")
    void getPositionFormatTest() {
        Car car = new Car("BMW", 5);
        String actaul = car.getPositionFormat();
        assertThat(actaul).contains("BMW").contains(" : ").contains("--");
        assertThat(actaul).isEqualTo("BMW : -----");
    }
}