package RacingCar;

import RacingCar.model.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RacingGameTest {

    private static final int CAR_COUNT = 3;
    private static final int STAGE_COUNT = 5;
    private static final int THRESHOLD = 4;


    @DisplayName("결과 테스트")
    @Test
    void start() {
        List<Result> results = RacingGame.getInstance().start(CAR_COUNT, STAGE_COUNT);
        assertThat(results.size()).isEqualTo(STAGE_COUNT);
    }


    @DisplayName("랜덤 이동 값 테스트 4이하면 false")
    @Test
    void isMovable() {
        boolean isMove = RacingGame.isMovable(THRESHOLD - 1);
        System.out.println(isMove);
        assertThat(isMove).isFalse();
    }
}

