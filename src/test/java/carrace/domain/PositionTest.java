package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("자동차 위치가 제대로 저장되는가")
    void getPosition() {
        Position position = new Position(5);
        assertThat(position.getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 위치 이동시 1칸 전진하는가")
    void forward() {
        Position position = new Position(5);
        position.forward();
        assertThat(position.getPosition()).isEqualTo(6);
    }

    @Test
    @DisplayName("자동차 위치 출력 테스트")
    void getResult() {
        Position position = new Position(5);
        assertThat(position.getResult()).isEqualTo("-----");
    }
}