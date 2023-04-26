package racing.controller;

import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.view.InputDto;
import racing.view.InputView;

import java.util.List;

public class RacingController {

    public static InputDto putGameConfig() {
        InputView inputView = new InputView();
        InputDto inputDto = inputView.InputCountOfUnit();
        return inputDto;
    }

    public static RacingGame create(InputDto dto) {
        RacingGame game = new RacingGame(dto.input(), dto.count());
        return game;
    }

    public static List<Cars> play(RacingGame game) {
        return game.playGame();
    }
    public static List<String> winners(RacingGame game) {
        return game.winners();
    }
}
