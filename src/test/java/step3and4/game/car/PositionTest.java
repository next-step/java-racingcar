package step3and4.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3and4.client.output.OutputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PositionTest {

    @Test
    @DisplayName("포지션은 한 칸 이동할 수 있다.")
    void a() {
        final OutputView.Fake outputView = new OutputView.Fake();
        final Position sut = new Position(0, outputView);

        final Position positionMovedOneSpace = sut.movedPosition();

        assertThat(positionMovedOneSpace).isEqualTo(new Position(1, outputView));
    }

    @Test
    @DisplayName("포지션 위치를 출력할 수 있다.")
    void b() {
        final OutputView.Fake outputView = new OutputView.Fake();
        final Position sut = new Position(0, outputView);

        assertThatCode(() -> sut.printPosition())
                .doesNotThrowAnyException();
    }

}
