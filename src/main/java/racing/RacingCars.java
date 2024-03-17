package racing;

public class RacingCars {
    private Car[] carArr;

    public RacingCars(int carCount) {
        Car[] carArr = new Car[carCount];
        for (int i = 0; i < carArr.length; i++) {
            carArr[i] = new Car(new CarLocation(0));
        }
        this.carArr = carArr;
    }

    public Car[] getCarArr() {
        return this.carArr;
    }
}
