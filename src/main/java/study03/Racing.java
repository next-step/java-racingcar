package study03;

import java.util.LinkedList;
import java.util.stream.IntStream;

/*
 *
 * Racing
 *
 * @version 1.0.0
 *
 * 2021-11-07
 *
 * Copyright tnals1422
 */
public class Racing {
    private final LinkedList<Car> cars = new LinkedList<>();
    private final IntStream tryCount;

    public Racing(String carCount, String tryCount) {

        for (int i = 1; i <= Integer.parseInt(carCount); i++) {
            this.cars.add(new Car());
        }
        this.tryCount = IntStream.range(1, (Integer.parseInt(tryCount) + 1));
    }

    public void start() {
        System.out.println("실행결과");
        tryCount.forEach(this::tryMoving);
    }

    private void tryMoving(int i) {
        System.out.println(i + "회차");
        cars.forEach(x -> {
            x.moveByCondition();
            System.out.println(x.getPosition());
        });

    }
}
