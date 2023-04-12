package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StagesTest {

    @Test
    @DisplayName("Stages 생성 테스트")
    void createStagesTest() {
        Stages stages = new Stages(Count.createCount(5));

        assertThat(stages.currentStage())
                .usingRecursiveComparison()
                .isEqualTo(Count.createCount(5));
    }

    @Test
    @DisplayName("Stages 게임 진행 테스트")
    void startGameTest() {
        Stages stages = new Stages(Count.createCount(5));

        stages.startGame(Cars.initCars("test"), () -> true);

        assertThat(stages.currentStage())
                .usingRecursiveComparison()
                .isEqualTo(Count.createCount(4));
    }

    @Test
    @DisplayName("Stage 종료 조건 테스트 - 진행중")
    void runningTest() {
        Stages stages = new Stages(Count.createCount(5));

        assertThat(stages.isRunning()).isTrue();
    }

    @Test
    @DisplayName("Stage 종료 조건 테스트 - 종료")
    void finishTest() {
        Stages stages = new Stages(Count.createCount(1));
        stages.startGame(Cars.initCars("test"), () -> true);

        assertThat(stages.isRunning()).isFalse();
    }

}