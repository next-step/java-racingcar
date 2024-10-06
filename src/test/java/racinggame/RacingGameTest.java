package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    public void 자동차_생성테스트(){
        RacingGame racingGame=new RacingGame(5);
        assertThat(racingGame.getCars()).hasSize(5);
        assertThat(racingGame.getCars()).contains(new Car(0));
    }

}
