package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 자동차 위치 기능
 * <pre>
 *     - 자동차가 얼만큼 전진했는지 기록한다.
 *     - 회차별 움직임을 저장한다.
 * </pre>
 */
class CarPositionTest {

    @Test
    @DisplayName("기록하는 값이 4보다 작은 경우 전진하지 않습니다.")
    void test01() {
        CarPosition position = makeCarPosition(1);
        assertThat(position.carActionRecordByRep(0)).isEqualTo(CarAction.STOP);
    }

    private CarPosition makeCarPosition(int number) {
        CarPosition position = new CarPosition();
        position.addRecord(number);
        return position;
    }

    @Test
    @DisplayName("기록하는 값이 4이상일 경우 전진합니다.")
    void test02() {
        CarPosition position = makeCarPosition(4);
        assertThat(position.carActionRecordByRep(0)).isEqualTo(CarAction.MOVE);
    }
}