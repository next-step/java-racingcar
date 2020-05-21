package racecar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("호출시 값을 +1 한다")
    void move() {
        int given = 1;
        given = given + 1;
        assertThat(given).isEqualTo(2);
    }

    @Test
    @DisplayName("입력한 수 만큼 '-'를 반복하는  문자열을 생성하는지 확인")
    void makePositionStatus() {
        int given = 3;
        String result = "-".repeat(given);
        assertThat(result).isEqualTo("---");
    }


}