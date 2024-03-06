package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @ParameterizedTest(name = "Position이 {arguments}인 경우 동치비교 ")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void hasPosition(int input) {
        Position position = new Position(input);
        assertThat(position.hasPosition(new Position(input))).isTrue();
    }

    @ParameterizedTest(name = "[{index}] position이 {0}일 때, add({1})")
    @CsvSource(value = {"2, 3", "1,5", "2,7", "3,4", "1,6"})
    @DisplayName("add() 호출 시 파라미터 만큼 position 필드에 더함")
    void add(int augend, int addend) {
        Position position = new Position(augend);
        position.add(addend);
        assertThat(position.hasPosition(new Position(augend + addend))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("position 필드가 같으면 동등한 Position 객체")
    void testEquals(int input) {
        assertThat(new Position(input)).isEqualTo(new Position(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:-","2:--","3:---","4:----","5:-----"}, delimiter = ':')
    void dashOfPosition(int input, String dash) {
        Position position = new Position(input);
        assertThat(position.dashOfPosition()).isEqualTo(dash);
    }
}