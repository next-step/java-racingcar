package step3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingTest {

    private static final String MOVE = "-";

    @Test
    @DisplayName("얻은 값이 4 이상이면 한칸 전진한다. ")
    void random_으로_얻은값이_4이상이면_한칸_전진한다() {
        Moving moving = new Moving();
        moving.move(5);
        Assertions.assertThat(moving.getMove()).isEqualTo(MOVE);
    }

    @Test
    @DisplayName("얻은 값이 4이면 한칸 전진한다.")
    void random_으로_얻은값이_4이면_한칸_전진한다() {
        Moving moving = new Moving();
        moving.move(4);
        Assertions.assertThat(moving.getMove()).isEqualTo(MOVE);
    }

    @Test
    @DisplayName("얻은 값이 4미만이면 아무일도 일어나지 않는다.")
    void random_으로_얻은값이_4미만이면_아무일도_일어나지_않는다() {
        Moving moving = new Moving();
        moving.move(3);
        Assertions.assertThat(moving.getMove()).isEqualTo("");
    }
}