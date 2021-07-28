package CarRacing;

public class CarRacing {
    private Cars cars;
    private StringBuilder stringBuilder = new StringBuilder();


    public CarRacing(Cars cars) {
        this.cars = cars;
    }


    public StringBuilder moveCarsToString(int tryCount) {

        for (int i = 0; i < tryCount; i++) {
            cars.getCars().forEach(car -> car.move());
            cars.getCars().forEach(car -> stringBuilder.append(new String(new char[car.getCarPosition()]).replace("\0", "-") + "\n"));
        }

        return stringBuilder;
    }
}
