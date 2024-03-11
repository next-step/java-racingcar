package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("[성공] 자동차 3개를 가진 자동차 리스트를 생성한다.")
    void 자동차_리스트_생성_자동차3() {
        Cars cars = new Cars(3);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[성공] 자동차 1개를 가진 자동차 리스트를 생성한다.")
    void 자동차_리스트_생성_자동차1() {
        Cars cars = new Cars(1);
        assertThat(cars.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("[성공] 자동차 3개를 가진 자동차 리스트의 자동차를 전진시킨다.")
    void 자동차_리스트_전진() {
        Cars cars = new Cars(3);
        // cars.move();
    }

    @Test
    @DisplayName("[성공] 자동차의 전진 횟수만큼 '-' 문자열을 반환한다.")
    void 자동차_전진문자_출력() {
        // Given
        Car car = new Car();

        // When
        // 3회 전진
        CarStatusSetterForTest.repeatMove(car, 3);

        // Then
        assertThat(car.toString()).isEqualTo("---");
    }

}
