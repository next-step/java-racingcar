package racing.car.game;

import org.junit.jupiter.api.Test;


public class RacingGameTest {

    @Test
    void 주어진_횟수만큼_자동차에_랜덤값_넣기() {
        //given
        int count = 4; //4회
        int carCount = 3; //3대
        RacingGame.countCarGoAndStop(count, carCount);
    }

}
