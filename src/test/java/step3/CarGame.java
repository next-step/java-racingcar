package step3;

public class CarGame {
    private Car[] cars;

    public CarGame(int carCnt, int tryCnt) {
        cars = new Car[carCnt];
        for (int i=0; i<carCnt; i++) {
            cars[i] = new Car(tryCnt);
        }
        this.cars = cars;
    }

    public int getCarsCnt() {
        return cars.length;
    }
}
