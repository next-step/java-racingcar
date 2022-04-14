package racingcar.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.play.ZeroToNineRandomPolicy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameServiceTest {

    RacingGameService racingGameService = new RacingGameService(new ZeroToNineRandomPolicy());


    @Test
    @DisplayName("playGame & findAll 동시 테스트")
    void playGame(){
        int tryNumber = 5;
        RacingCar racingCar1 = new RacingCar(0, 0);
        racingGameService.playGame(racingCar1, tryNumber);

        RacingCar racingCar2 = new RacingCar(1, 0);
        racingGameService.playGame(racingCar2, tryNumber);

        List<RacingCar> result = racingGameService.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}