package racinggame.controller;

import racinggame.domain.CommaPatternNames;
import racinggame.domain.RacingGame;
import racinggame.dto.InputDto;
import racinggame.dto.Result;
import racinggame.random.DefaultRandomNumberGenerator;

public class GameController {

    public Result play(InputDto inputDto) {
        RacingGame racingGame = new RacingGame(inputDto.getRepeatCount(),
                new CommaPatternNames(inputDto.getCarNames()));
        return racingGame.start(new DefaultRandomNumberGenerator());
    }
}
