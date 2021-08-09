package race;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private int carCount;

    private int gameCount;

    public CarRace() {
        this.carCount = setCarCount();
        this.gameCount = setGameCount();
    }

    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        carRace.playGame();
    }

    protected int setCarCount() {
        InputView.askCarCount();
        return InputView.inputOutput();
    }

    protected int setGameCount() {
        InputView.askGameCount();
        return InputView.inputOutput();
    }

    protected void playGame() {
        Cars carList = createCarList();
        for (int i = 0; i < gameCount; i++) {
            printResult(moveCar(carList));
        }
    }

    protected Cars moveCar(Cars carList) {
        for (Car car: carList.getCarList()) {
            car.addDistance();
        }
        return carList;
    }

    protected void printResult(Cars carList) {
        ResultView.printResult(carList);
    }

    protected Cars createCarList() {
        List<Car> carList = new ArrayList<>();
        int tempCarCount = carCount;
        while (tempCarCount-- > 0) {
            Car car = new Car("");
            carList.add(car);
        }
        return new Cars(carList);
    }

}
