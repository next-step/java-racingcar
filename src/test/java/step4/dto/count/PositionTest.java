package step4.dto.count;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("객체생성시 기본값은 0 이다")
    public void defaultTest() {
        assertThat(new Position().getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3", "5,5", "6,6", "1,1"})
    @DisplayName("최대값 전달시 새로운 객체로 반환된다")
    public void maxPosition(int input, int expected) {
        Position position = new Position(input);

        assertThat(position.maxPosition()).isEqualTo(new Position(expected));
    }

}