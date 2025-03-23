public class RacingManager {
    private final Cars cars;
    private final CarsSnapShots carsSnapShots;
    private final int tryNum;

    public RacingManager(int carNum, int tryNum) {
        if (carNum <= 0 || tryNum <= 0) {
            throw new IllegalArgumentException("자동차 대수와 시도 횟수는 0보다 커야 합니다.");
        }
        this.tryNum = tryNum;
        this.cars = new Cars(carNum);
        carsSnapShots = new CarsSnapShots();
    }

    public void play() {
        for (int i = 0; i < tryNum; i++) {
            this.cars.move();
            carsSnapShots.add(this.cars);
        }
    }

    public CarsSnapShots getCarsSnapShots() {
        return this.carsSnapShots;
    }
}
