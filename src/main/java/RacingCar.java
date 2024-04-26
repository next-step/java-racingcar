import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final Cars cars;
    private int carCount;
    private int moveCount;

    public RacingCar(MovePolicy movePolicy, String names) {
        this.cars = new Cars(createCarList(movePolicy, names));
    }

    private List<Car> createCarList(MovePolicy movePolicy, String names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names.split(",")) {
            carList.add(new Car(movePolicy, name));
        }

        return carList;
    }

    public void start() {
        int numberOfTry = Printer.askNumberOfTry();

        for (int i = 0; i < numberOfTry; i++) {
            cars.move();
        }

        Printer.printResult(cars);
        Printer.printWinner(cars);
    }

    public List<Car> getWinners() {
        return this.cars.findWinners();
    }

    public int getCarCount() {
        return this.cars.getCount();
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
