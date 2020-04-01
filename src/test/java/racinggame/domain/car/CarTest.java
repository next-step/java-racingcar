package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CarTest {

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "0:0",
            "1:0",
            "3:0",
            "4:1",
            "7:1",
            "9:1"}, delimiter = ':')
    void moveCar_success(int randNum, int expect) {
        //given
        Car car = new Car("car");

        //when
        car = car.moveCar(randNum);

        //then
        assertThat(car.getPosition()).isEqualTo(expect);
    }

    @DisplayName("10을 기준으로이동 거리를 비교하여 더 멀리 갔는지 확인 한다")
    @Test
    public void isMovedFarThan_success() throws Exception {
        //given
        Car car = new Car("a", 1);
        Car car2 = new Car("b", 2);

        //then
        assertThat(car.compareTo(car2)).isEqualTo(-1);
    }
}
