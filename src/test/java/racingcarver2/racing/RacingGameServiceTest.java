package racingcarver2.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.play.ZeroToNineRandomPolicy;
import racingcar.racing.RacingGameService;


import static org.junit.jupiter.api.Assertions.*;

class RacingGameServiceTest {

    RacingGameService racingGameService = new RacingGameService(new ZeroToNineRandomPolicy());


    @Test
    void startRacingGame(){

    }

}