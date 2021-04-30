public class Setup {

    public static final Car car;
    public static Cars cars = new Cars();

    static {
        car = new Car("바나나차");
    }

    Setup(){
        setCars();
    }

    private void setCars() {
        Car car1 = new Car("바나나차차");
        Car car2 = new Car("딸기차차");
        Car car3 = new Car("토마토차차");

        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
    }
}
