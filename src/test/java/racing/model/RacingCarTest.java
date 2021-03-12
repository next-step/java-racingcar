package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void init() {
        racingCar = new RacingCar("BOOM");

    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void moveTest() {
        //given
        int moveCount = 4;

        //when
        racingCar.move(moveCount);

        //then
        assertEquals(new Position(1), racingCar.getPosition());
    }

    @DisplayName("자동차 정지 테스트")
    @Test
    void stopTest() {
        //given
        int moveCount = 3;

        //when
        racingCar.move(moveCount);

        //then
        assertEquals(new Position(0), racingCar.getPosition());
    }

    @DisplayName("앞으로 가는 조건 테스트")
    @Test
    void isForward() {
        //given
        int randomValue = 4;

        //then
        assertThat(racingCar.isForward(randomValue)).isTrue();
    }

    @DisplayName("포지션이 같은지 비교 테스트")
    @Test
    void isSame() {
        //given
        RacingCar racingCar = new RacingCar("LG", 5);
        Position position = new Position(5);

        //then
        assertThat(racingCar.isSame(position)).isTrue();
    }
}