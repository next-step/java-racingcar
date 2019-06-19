package racingcar.logic;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultGameLogic implements GameLogic {

    private final RandomValueProvider randomValueProvider;

    public DefaultGameLogic(RandomValueProvider randomValueProvider) {
        this.randomValueProvider = randomValueProvider;
    }

    @Override
    public List<Integer> move(List<Integer> carPositions) {
        return carPositions.stream()
                .map(position -> isMove(randomValueProvider.get()) ? position + 1 : position )
                .collect(Collectors.toList());
    }

    private boolean isMove(Integer num) {
        return num > 4;
    }
}
