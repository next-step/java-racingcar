package racing.model;

import racing.view.ResultView;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class GameTurn {

    private final int gameTurn;

    public GameTurn(int gameTurn) {
        if (gameTurn < 0) {
            throw new IllegalArgumentException("게임 턴은 0이상이여야 합니다.");
        }
        this.gameTurn = gameTurn;
    }

    /**
     * 게임 턴마다 자동차를 움직이고 결과 값을 보여주는 메서드
     */
    public RacingGame play(RacingGame racingGame, ResultView resultView) {
        for (int i = 0; i < gameTurn; i++) {
            List<Integer> randomValues = createRandomValue(racingGame);
            resultView.turnResultView(turn(racingGame, randomValues).createDtoList());
        }
        return racingGame;
    }

    /**
     * 매턴 마다 실행되는 메서드
     */
    public RacingCars turn(RacingGame racingGame, List<Integer> randomValues) {
        return racingGame.moveAndStop(randomValues);
    }

    /**
     * 자동차가 이동할 랜덤값 생성 메서드
     */
    private List<Integer> createRandomValue(RacingGame racingGame) {
        return new Random()
                .ints(0, 10)
                .limit(racingGame.carCount())
                .boxed()
                .collect(toList());
    }
}
