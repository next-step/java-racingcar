package study;

import com.step3.model.car.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class PositionTest {
    @ParameterizedTest
    @DisplayName("Position class 생성자 test")
    @CsvSource(value = {"1,true", "0,false"})
    void create(int value, boolean expected) {
        Position position = new Position(1);
        Assertions.assertEquals(position.equals(new Position(value)), expected);
    }

    @ParameterizedTest
    @DisplayName("Position 이동 메서드 test")
    @CsvSource(value = {"1,true", "0,false"})
    void add(int value, boolean expected) {
        Position position = new Position(0).add();
        Assertions.assertEquals(position.equals(new Position(value)), expected);
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
