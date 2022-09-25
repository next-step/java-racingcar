package step3;

public class Cars {
    Car[] cars;

    public Cars(int n) {
        this.cars = new Car[n];
        this.init();
    }

    public void init() {
        for (int i=0; i<cars.length; i++) {
            cars[i] = new Car();
        }
    }

    public void playGame() {
        for (Car car : this.cars) {
            car.play();
        }
    }
}
