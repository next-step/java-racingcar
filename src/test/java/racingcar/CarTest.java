import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("랜덤값가져오기(0이상~9이하)")
    void 랜덤값가져오기() {
        Car car = new Car();

        assertThat(car.getRandomNumber()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("이동또는스톱")
    void 이동또는스톱() {
        Car car = new Car();

        int moveCount = car.getMoveCount();

        // 스톱 테스트
        car.moveForwardOrStop(3);
        assertThat(car.getMoveCount()).isEqualTo(moveCount);

        // 전진 테스트
        car.moveForwardOrStop(4);
        assertThat(car.getMoveCount()).isEqualTo(moveCount + 1);
    }

}
