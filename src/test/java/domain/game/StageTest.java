package domain.game;

import domain.game.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StageTest {
    @DisplayName("음수값은 허용하지 않는다")
    @Test
    void minusStage() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Stage(-1))
                .withMessageMatching("음수값은 허용되지 않습니다.");
    }

    @DisplayName("총 stage 이후 이동할 수 없다")
    @Test
    void checkTotalStage() {
        Stage stage = new Stage(1);

        stage.next();
        assertThat(stage.hasNext()).isFalse();
    }
}
