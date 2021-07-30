package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("자동차 위치 테스트")
public class RacingCarPositionTest {
    private RacingCarPosition position;

    @BeforeEach
    void setUp() {
        position = new RacingCarPosition();
    }

    @DisplayName("초기 자동차 위치값은 0 이어야 한다.")
    @Test
    public void initialPositionTest() {
        // when, then
        assertEquals(position.getPosition(), 0);
    }

    @DisplayName("자동차 위치는 1씩 증가한다.")
    @Test
    public void increasePositionTest() {
        // when
        position.increaseOne();

        // then
        assertEquals(position.getPosition(), 1);
    }
}
