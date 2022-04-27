package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("현재 위치를 문자열로 표현한다")
    void initPosition() {
        Position position = new Position("");

        String initPosition = position.show();

        assertThat(initPosition).isEqualTo("");
    }

    @Test
    @DisplayName("현재 위치를 숫자로 표현한다")
    void showPositionLength() {
        Position position = new Position("");

        int initPosition = position.length();

        assertThat(initPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 위치에서 한칸 전진한다")
    void movingUnit() {
        Position position = new Position("");
        String expect = "-";

        position.forward();

        assertThat(position.show()).isEqualTo(expect);
    }
}
