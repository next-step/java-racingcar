package racecar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest extends Random {

    @Override
    public int nextInt() {
        return 5;
    }

    @Test
    @DisplayName("랜덤으로 생성한 값이 4이상인 경우 값을 +1 한다")
    void move() {
        int number = this.nextInt();
        int result = 0;
        if (number >= Rules.WIN_CONDITION)
            result += 1;
        assertThat(result).isEqualTo(1);

    }

    @Test
    @DisplayName("주어진 숫자만큼 '-' 문자를 반복 한다")
    void makePositionStatus() {
        int given = 3;
        String result = "-".repeat(given);
        assertThat(result).isEqualTo("---");
    }

}