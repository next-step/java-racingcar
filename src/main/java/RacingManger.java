public class RacingManger {

    private Car[] cars;

    public RacingManger(int carNum) {
        makeCars(carNum);
    }

    private Car[] makeCars(int carNum) {
        this.cars = new Car[carNum];
        for (int i = 0; i < carNum; i++) {
            this.cars[i] = new Car();
        }
        return this.cars;
    }

    public void play() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public Car[] getCars() {
        return this.cars;
    }
}
