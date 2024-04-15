import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final MovePolicy movePolicy;
    private final Printer printer = new Printer();

    private int carCount;
    private int moveCount;

    public RacingCar(MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
    }

    public void start() {
        int numberOfCar = printer.askNumberOfCar();
        int numberOfTry = printer.askNumberOfTry();

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            carList.add(new Car(movePolicy));
        }

        Cars cars = new Cars(carList);

        for (int i = 0; i < numberOfTry; i++) {
            cars.move();
        }

        printer.printResult(cars);
    }

    public int getCarCount() {
        return this.carCount;
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
