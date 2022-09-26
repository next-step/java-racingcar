package racing.service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.MovableStrategy;
import racing.ui.ResultView;
import racing.ui.ResultViewImpl;

public class RacingGameServiceImpl implements RacingGameService {

    private final int totalCount;
    private final int tryCount;

    public RacingGameServiceImpl(int totalCount, int tryCount) {
        this.totalCount = totalCount;
        this.tryCount = tryCount;
    }

    @Override
    public Cars prepare() {
        return new Cars(IntStream.range(0, totalCount)
            .mapToObj(index -> new Car())
            .collect(Collectors.toList()));
    }

    @Override
    public void racing(Cars cars, MovableStrategy movableStrategy) {
        ResultView resultView = new ResultViewImpl();

        IntStream.range(0, tryCount)
            .forEach(index -> {
                cars.move(movableStrategy);
                cars.print(resultView);
            });
    }

}
