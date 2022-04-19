package racing_game.model;

import racing_game.util.Delimiter;
import racing_game.view.InputView;

import java.util.Optional;

public class GameCondition {

    private static final String WHAT_ARE_THE_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String HOW_MANY_TRY = "시도할 회수는 몇 회 인가요?";
    private final String[] racingCarNames;
    private final int totalRounds;

    public GameCondition() {
        this.racingCarNames = Optional.of(InputView.inputString(WHAT_ARE_THE_NAMES).split(Delimiter.COMMA.symbol)).orElseThrow();
        this.totalRounds = Optional.of(InputView.inputInteger(HOW_MANY_TRY)).orElseThrow();
    }

    public int getTotalRounds() {
        return this.totalRounds;
    }

    public String[] getTotalRacingCarCount() {
        return this.racingCarNames;
    }
}
