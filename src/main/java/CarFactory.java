public class CarFactory {
    public static Car[] createCars(int size) {
        Car[] cars = new Car[size];
        for (int i = 0; i < size; i++) {
            cars[i] = new Car();
        }

        return cars;
    }
}
