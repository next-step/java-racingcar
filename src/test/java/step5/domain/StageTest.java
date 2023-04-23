package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StageTest {

    private Stage stage;

    @BeforeEach
    void initialize() {
        stage = new Stage(RacingInformation.of("테스트", 5));
    }

    @Test
    @DisplayName("Stage 생성 테스트")
    void Stage_생성_테스트() {


        assertThat(stage.getCurrentStage())
                .usingRecursiveComparison()
                .isEqualTo(5);
    }

    @Test
    @DisplayName("Stage 진행시 reps 감소 테스트")
    void Stage_진행시_reps_감소_테스트() {

        stage.play(() -> true);

        assertThat(stage.getCurrentStage())
                .usingRecursiveComparison()
                .isEqualTo(4);
    }


    @Test
    @DisplayName("레이싱_진행중_테스트")
    void 레이싱_진행중_테스트() {

        stage.play(() -> true);


        assertThat(stage.hasMoreStage()).isTrue();
    }

    @Test
    @DisplayName("레이싱_종료_테스트")
    void 레이싱_종료_테스트() {

        stage.play(() -> true);
        stage.play(() -> true);
        stage.play(() -> true);
        stage.play(() -> true);
        stage.play(() -> true);


        assertThat(stage.hasMoreStage()).isFalse();
    }
}