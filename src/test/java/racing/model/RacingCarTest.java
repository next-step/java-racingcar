package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void init() {
        racingCar = new RacingCar("BOOM", 0);

    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void moveTest() {
        //given
        int moveCount = 4;

        //when
        racingCar.move(moveCount);

        //then
        assertEquals(1, racingCar.getPosition());
    }

    @DisplayName("자동차 정지 테스트")
    @Test
    void stopTest() {
        //given
        int moveCount = 3;

        //when
        racingCar.move(moveCount);

        //then
        assertEquals(0, racingCar.getPosition());
    }
}