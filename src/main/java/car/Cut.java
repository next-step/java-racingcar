package car;

public class Cut {

    public Car getCar(String carName) {
        int length = carName.length();
        if(length > 5) {
            length = 5;
        }
        Car car = new Car(carName.substring(0, length), 0);
        return car;
    }
}
