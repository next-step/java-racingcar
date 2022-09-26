package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final static String NEXT_LINE = "\n";
    private final static String GAME_RESULT = "게임 결과";
    private final static int FIRST = 0;

    private final GameSet gameSet;
    private List<Car> cars;
    private StringBuilder builder = new StringBuilder(GAME_RESULT);

    public RacingGame(GameSet gameSet) {
        if (gameSet == null) {
            throw new IllegalArgumentException("입력된 게임 설정이 올바르지 않습니다.");
        }
        this.gameSet = gameSet;
        lineUp();
    }

    public void start() {
        round();
    }

    private void lineUp() {
        cars = IntStream.range(FIRST, this.gameSet.getNumberOfCars())
                .mapToObj(car -> new Car())
                .collect(Collectors.toList());
    }

    private void round() {
        for (int round = FIRST; round < this.gameSet.getNumberOfMove(); round++) {
            racing(builder);
        }
    }

    private void racing(StringBuilder builder) {
        for (Car car : cars) {
            builder.append(NEXT_LINE);
            car.move(this.gameSet.getRule().move());

            builder.append(car.getPosition());
        }
        builder.append(NEXT_LINE);
    }

    public String result() {
        return builder.toString();
    }

    public GameSet getGameSet() {
        return gameSet;
    }

    public List<Car> getCars() {
        return cars;
    }
}
