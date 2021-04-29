package ugemang.nextstep;

import ugemang.nextstep.di.Injection;
import ugemang.nextstep.service.RacingGame;

public class main {
    public static void main(String[] args){
        RacingGame racingGame = Injection.provideRacingGame();
        racingGame.run();
        racingGame.getWinner();
    }
}
