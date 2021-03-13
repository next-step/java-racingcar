package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @DisplayName("position 생성자 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,0})
    void positionTest(int number) {
        Position position = new Position(number);
        assertEquals(position.getPosition(), number);
    }

    @DisplayName("update 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,0})
    void positionUpdateTest(int number) {
        Position position = new Position(number);
        position.update();
        assertEquals(position.getPosition(), number+1);
    }

    @DisplayName("음수로 입력시 테스트")
    @Test
    void positionMinusTest() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }




}