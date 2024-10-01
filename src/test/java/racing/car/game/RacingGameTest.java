package racing.car.game;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;


public class RacingGameTest {

    @Test
    void 주어진_횟수만큼_자동차에_랜덤값_넣기() {
        //given
        int count = 4;
        int carCount = 3;

        try(MockedStatic<RacingGame> staticRacingGame = mockStatic(RacingGame.class)) {
            RacingGame.countCarGoAndStop(count, carCount);
            //잘 호출되었는지 확인
            staticRacingGame.verify(() -> RacingGame.countCarGoAndStop(count, carCount), times(1));
        }
    }
}
