import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @ParameterizedTest
    @CsvSource({"0,0", "3,0", "4,1", "9,1"})
    @DisplayName("4 이상의 숫자를 입력하면 1칸, 4 미만의 숫자를 입력하면 0칸 전진한다.")
    void moveTest(int number, int expectedLocation) {
        final Car car = new Car("pobi");
        car.makeMove(number);
        assertThat(car.location()).isEqualTo(new Location(expectedLocation));
    }

    @Test
    @DisplayName("자동차에 이름을 저장할 수 있다.")
    void carWithNameTest() {
        assertThat(new Car("pobi").name()).isEqualTo(new CarName("pobi"));
    }
}