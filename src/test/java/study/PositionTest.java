package study;

import com.step3.model.car.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PositionTest {
    @Test
    @DisplayName("Position class 생성자 test")
    void create() {
        Position position = new Position(1);
        assertThat(position.equals(new Position(1))).isTrue();
        assertThat(position.equals(new Position(0))).isFalse();
    }

    @Test
    @DisplayName("Position 이동 메서드 test")
    void add() {
        Position position = new Position(1);
        assertThat(position.add().equals(new Position(2))).isTrue();
        assertThat(position.add().equals(new Position(1))).isFalse();
    }

    @Test
    @DisplayName("Position getter 메서드 test")
    void get() {
        Position position = new Position(1);
        assertThat(position.get()).isEqualTo(1);
        assertThat(position.add().get()).isEqualTo(2);
    }

    @Test
    @DisplayName("Position compareTo 메서드 test")
    void compareTo() {
        Position position = new Position(1);
        assertThat(position.compareTo(new Position(1))).isEqualTo(0);
        assertThat(position.compareTo(new Position(2))).isLessThan(0);
        assertThat(position.compareTo(new Position(0))).isGreaterThan(0);
    }
}
