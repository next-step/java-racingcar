package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private final static int FIRST_ROUND = 1;
    private final static int FIRST_CAR = 0;

    private final GameSet gameSet;
    private GameResult gameResult;
    private List<Car> cars;

    public Game(GameSet gameSet) {
        if (gameSet == null) {
            throw new IllegalArgumentException("입력된 게임 설정이 올바르지 않습니다.");
        }
        this.gameSet = gameSet;
        lineUp();
    }

    public void start() {
        gameResult = new GameResult(this);

        IntStream.rangeClosed(FIRST_ROUND, gameSet.getNumberOfMove())
                .mapToObj(round -> new Round())
                .forEach(round -> {
                    round.racing(cars, gameSet.getMoveStrategy());
                    gameResult.addRound(round);
                });
    }

    private void lineUp() {
        cars = IntStream.range(FIRST_CAR, gameSet.getCarNames().size())
                .mapToObj(car -> new Car(gameSet.getCarNames().get(car)))
                .collect(Collectors.toList());
    }

    public GameSet getGameSet() {
        return gameSet;
    }

    public List<Car> getCars() {
        return cars;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
