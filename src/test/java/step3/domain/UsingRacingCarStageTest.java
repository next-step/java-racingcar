package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsingRacingCarStageTest {

    private UsingRacingCarStage usingRacingCarStage;

    @BeforeEach
    void initialize() {
        List<UsingNameRacingCar> usingNameRacingCarList = List.of(UsingNameRacingCar.of("테스트1"));

        usingRacingCarStage = UsingRacingCarStage.of(Reps.of(5), usingNameRacingCarList);
    }

    @Test
    @DisplayName("Stage 생성 테스트")
    void Stage_생성_테스트() {


        assertThat(usingRacingCarStage.getReps().getReps())
                .usingRecursiveComparison()
                .isEqualTo(5);
    }

    @Test
    @DisplayName("Stage 진행시 reps 감소 테스트")
    void Stage_진행시_reps_감소_테스트() {

        usingRacingCarStage.play(() -> true);

        assertThat(usingRacingCarStage.getReps().getReps())
                .usingRecursiveComparison()
                .isEqualTo(4);
    }
}