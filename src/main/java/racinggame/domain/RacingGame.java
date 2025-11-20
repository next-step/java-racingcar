package racinggame.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private TryNo tryNo;

    public RacingGame(String carNames, int tryNo) {
        this(new Cars(carNames), new TryNo(tryNo));
    }

    public RacingGame(List<Car> cars, int tryNo) {
        this(cars, new TryNo(tryNo));
    }

    public RacingGame(List<Car> cars, TryNo tryNo) {
        this(new Cars(cars), tryNo);
    }

    public RacingGame(Cars cars, TryNo tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
    }

    public void race() {
        if (this.tryNo.isEnd()) {
            throw new IllegalStateException("게임이 종료되었습니다.");
        }
        this.tryNo = tryNo.decrease();
        this.cars.race();
    }

    public boolean racing() {
        return this.tryNo.isPositive();
    }

    public Cars getCar() {
        return this.cars;
    }

    public Winners getWinners() {
        return this.cars.findWinners();
    }

    @Override
    public String toString() {
        return "RacingGame{" +
                "cars=" + cars +
                ", tryNo=" + tryNo +
                '}';
    }
}
