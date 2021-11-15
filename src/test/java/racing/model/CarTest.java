package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주 - Car 단위 테스트")
class CarTest {

    @Test
    @DisplayName("3단계 - 자동차 랜덤 행동 이동 기능")
    void moveRandom() {
        Car car = new Car("");

        for (int i = 0; i < 10; i++) {
            car.move(i);
        }

        assertThat(car.getMovingDistance())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("3단계 - 자동차 전진 기능")
    void go() {
        Car car = new Car("");
        int goValue = 4;

        car.move(goValue);
        car.move(goValue);
        car.move(goValue);

        assertThat(car.getMovingDistance())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("3단계 - 자동차 정지 기능")
    void stopCar() {
        // 아무것도 하지 않으면 정지
        assertThatCode(() -> new Car(""))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("4단계 - 자동차 이름 부여")
    void setName() {
        String name = "정상";
        assertThatCode(() -> new Car(name))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("4단계 - 자동차 이름 부여 실패")
    void setLongName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("긴이름입니다")); // Korean
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("long__")); // English
    }

    @ParameterizedTest
    @CsvSource(value = {"0,true", "4,false"})
    void isEqualMovingDistance(int movingDistance, boolean expectedIsEqual) {
        Car car = new Car("");
        assertThat(car.isEqualMovingDistance(movingDistance))
                .isEqualTo(expectedIsEqual);
    }
}
