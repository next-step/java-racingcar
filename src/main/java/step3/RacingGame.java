package step3;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private CarList carList;
    private Random random = new Random();

    public RacingGame(int carCnt) {
        carList = new CarList(
                Stream.generate(() -> new Car())
                        .limit(carCnt)
                        .collect(Collectors.toList())
        );
    }

    public void play() {
        carList.getCarList().forEach(it -> {
            if (isMove())
                it.move();
        });
    }

    private boolean isMove() {
        return random.nextInt(10) >= 4;
    }

    public CarList getCarList() {
        return carList;
    }
}
