package racing.refactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("자동차 위치 테스트")
class PositionTest {

    @Test
    @DisplayName("같은 값의 객체 생성 후 비교 시 결과 true")
    public void createAndEquals() {
        Position position1 = new Position(10);
        Position position2 = new Position(10);

        assertEquals(position1, position2);
    }

    @Test
    @DisplayName("낮은 값에 높은 값 비교 시 true")
    public void thisFollowingIsHigher() {
        Position lowPosition = new Position(1);
        Position highPosition = new Position(10);

        assertTrue(lowPosition.higherThan(highPosition));
    }

    @Test
    @DisplayName("0을 이동 시 1과 같음")
    public void move() {
        Position moveTarget = new Position(0);
        moveTarget.move();

        assertEquals(new Position(1), moveTarget);
    }
}