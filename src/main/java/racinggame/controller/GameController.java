package racinggame.controller;

import racinggame.domain.CommaSplitter;
import racinggame.domain.Names;
import racinggame.domain.RacingGame;
import racinggame.dto.InputDto;
import racinggame.dto.Result;
import racinggame.random.DefaultRandomNumberGenerator;

public class GameController {

    public Result play(InputDto inputDto) {
        RacingGame racingGame = new RacingGame(inputDto.getRepeatCount(),
                new Names(inputDto.getCarNames(), new CommaSplitter()));
        return racingGame.start(new DefaultRandomNumberGenerator());
    }
}
