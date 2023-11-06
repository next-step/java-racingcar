package carRacing;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class RacingProcessTest {

    private int carCount;
    private RacingProcess racingProcess;
    MovingStrategy movingStrategy;

    @BeforeEach
    void create() {
        movingStrategy = new GreaterThanThreeMovingStrategy();
        carCount = 5;
        racingProcess = new RacingProcess(carCount, movingStrategy);
    }

    @Test
    @DisplayName("경주방식 객체 생성이 되었는지 확인")
    void 경주방식_객체_확인() {
        assertThat(racingProcess).isNotNull();
    }


    @Test
    @DisplayName("경주시작 시 자동차 객체를 입력한 자동차 대수만큼 생성시키는지 확인")
    void 자동차준비_확인() {

        assertThat(racingProcess.getCarsDistance()).hasSize(carCount);
    }

    @Test
    @DisplayName("자동차 경주를 실행시켜 모든 자동차를 전진하게 할 때 결과 확인")
    void 자동차경주_라운드_진행_결과() {
        NumberGenerator movableRandomGenerator = new MovableRandomGenerator();
        racingProcess.roundPlay(movableRandomGenerator);
        assertThat(racingProcess.getCarsDistance()).containsOnly(1, 1, 1, 1, 1);
    }


}
