package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    @DisplayName("생정자 테스트: 생성자에 아무런 파라미터를 넘기지 않으면 0")
    void create() {
        Position position1 = new Position();
        Position position2 = new Position(0);

        assertEquals(position1, position2);
    }

    @Test
    @DisplayName("forward 테스트")
    void forward() {
        Position position = new Position(2);
        Position expectedResult = new Position(3);

        position.forward();

        assertEquals(expectedResult, position);
    }

    @Test
    @DisplayName("compareTo 테스트: 피연산자의 값이 작으면 1을 리턴하고 나머지 경우에는 -1을 리턴한다.")
    void compareTo() {
        Position position1 = new Position(1);
        Position position2 = new Position(2);

        assertEquals(-1, position1.compareTo(position2));
        assertEquals(1, position2.compareTo(position1));
    }

}
