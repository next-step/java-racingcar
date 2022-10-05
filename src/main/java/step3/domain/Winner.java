package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Winner {

    private final List<Car> winnerList;

    public Winner(GameInfo gameInfo) {
        this.winnerList = winner(gameInfo);
    }

    private List<Car> winner(GameInfo gameInfo) {
        return winnerList(gameInfo, maxPosition(gameInfo));
    }

    private int maxPosition(GameInfo gameInfo) {
        return gameInfo.getCarList()
                .stream()
                .mapToInt(Car::getPosition)
                .filter(car -> car >= 0)
                .max()
                .orElse(0);
    }

    private List<Car> winnerList(GameInfo gameInfo, int maxPosition) {
        return IntStream.range(0, gameInfo.getCarList().size())
                .filter(i -> gameInfo.getCarList().get(i).getPosition() == maxPosition)
                .mapToObj(i -> gameInfo.getCarList().get(i))
                .collect(Collectors.toList());
    }

    public List<Car> getWinnerList() {
        return winnerList;
    }
}