package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = RacingCar.newInstanceByCarMove(3, 5);
    }
    
    @Test
    @DisplayName("step3. 차량의 전진여부 테스트")
    public void testRandomMove() {
        assertThat(racingCar.isMoveForward()).isTrue();
    }
    
    @Test
    @DisplayName("step3. 1회차 이동 테스트")
    public void testSingleRound() {
        racingCar.goSingleRound(0);
    }
    
    @Test
    @DisplayName("step3. 자동차 경주 테스트")
    public void testFullRound() {
        racingCar.goFullRace();
    }
}