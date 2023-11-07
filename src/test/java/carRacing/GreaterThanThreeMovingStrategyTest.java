package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GreaterThanThreeMovingStrategyTest {
    MovingStrategy movingStrategy;
    @BeforeEach
    void create(){
       movingStrategy = new GreaterThanThreeMovingStrategy();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("값이 3이하 일때 False 반환")
    void 전진전략_False_확인(int randomNumber) {

        boolean result = movingStrategy.isRide(randomNumber);

        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("값이 4이상 일때 Ture 반환")
    void 전진전략_Ture_확인(int randomNumber) {

        boolean result = movingStrategy.isRide(randomNumber);

        assertThat(result).isTrue();
    }
}
