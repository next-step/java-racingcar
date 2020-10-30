/**
 * 클래스 이름: CarTest
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스의 테스트")
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @ParameterizedTest
    @DisplayName("move 함수에서 4이상의 경우에만 전진해야 한다.")
    @CsvSource(value = {"0:1", "1:1", "2:1", "3:1", "4:2", "5:2", "6:2", "7:2", "8:2", "9:2"}, delimiter = ':')
    void move(int randomNum, int movedPosition) {
        assertThat(this.car.getPosition())
                .isEqualTo(1);
        this.car.move(randomNum);
        assertThat(this.car.getPosition())
                .isEqualTo(movedPosition);
    }
}
