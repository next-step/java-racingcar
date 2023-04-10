package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarActionsTest {
    private CarActions actions;

    @BeforeEach
    void setup() {
        actions = new CarActions();
    }

    @Test
    @DisplayName("CarActions 에 MOVE 액션이 정상적으로 추가됩니다.")
    void test01() {
        actions.addMove();
        assertThat(actions.action(0)).isEqualTo(CarAction.MOVE);
    }

    @Test
    @DisplayName("CarActions 에 STOP 액션이 정상적으로 추가됩니다.")
    void test02() {
        actions.addStop();
        assertThat(actions.action(0)).isEqualTo(CarAction.STOP);
    }

    @Test
    @DisplayName("CarActions 에 CarAction 이 리스트로 저장됩니다.")
    void test03() {
        actions.addMove();
        actions.addStop();
        Assertions.assertAll(
                () -> assertThat(actions.action(0)).isEqualTo(CarAction.MOVE),
                () -> assertThat(actions.action(1)).isEqualTo(CarAction.STOP),
                () -> assertThat(actions.size()).isSameAs(2)
        );
    }
}