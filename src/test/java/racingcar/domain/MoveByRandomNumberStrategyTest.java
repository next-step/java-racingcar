package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveByRandomNumberStrategyTest {

    private final int MOVABLE_CAR_MIN_NUMBER = MoveByRandomNumberStrategy.MOVABLE_CAR_MIN_NUMBER;

    @Test
    void move는_MOVABLE_CAR_MIN_NUMBER_이상의_수를_입력하면_1칸_움직인_Position을_반환합니다() {
        int step = 0;
        Position position = new Position(step);
        Position movedPosition = new Position(step + 1);
        int fakeNumberForMove = MOVABLE_CAR_MIN_NUMBER;
        MoveStrategy strategy = new MoveByRandomNumberStrategy(new FakeRandomNumberFactory(fakeNumberForMove));

        Position result = strategy.move(position);

        assertThat(result).isEqualTo(movedPosition);
    }

    @Test
    void move는_MOVABLE_CAR_MIN_NUMBER_미만의_수를_입력하면_움직이지_않은_Position을_반환합니다() {
        int step = 0;
        Position position = new Position(step);

        int fakeNumberForStop = MOVABLE_CAR_MIN_NUMBER - 1;

        MoveStrategy strategy = new MoveByRandomNumberStrategy(new FakeRandomNumberFactory(fakeNumberForStop));
        Position result = strategy.move(position);

        assertThat(result).isEqualTo(position);
    }

}
