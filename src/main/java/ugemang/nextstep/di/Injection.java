package ugemang.nextstep.di;

import ugemang.nextstep.service.RacingGame;
import ugemang.nextstep.service.RacingGameService;
import ugemang.nextstep.service.RacingGameServiceImpl;

public class Injection {
    public static RacingGameService provideRacingGameService(){
        return new RacingGameServiceImpl();
    }

    public static RacingGame provideRacingGame(){
        return new RacingGame(provideRacingGameService());
    };
}
