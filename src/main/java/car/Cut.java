package car;

public class Cut {

    public Car getCar(String carName) {
        int length = carName.length();
        if(length > 5)
            length = 5;
        Car c = new Car();
        carName = carName.substring(0, length);
        c.setName(carName);
        return c;
    }
}
