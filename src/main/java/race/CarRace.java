package race;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private int carCount;

    private int gameCount;

    private String[] carDistance;

    public static void main(String[] args) {
        CarRace carRace = new CarRace();
    }

    public void initGame() {
        carCount = setCarCount();
        gameCount = setGameCount();
        Cars carList = new Cars(createCarList());
        for (Car car: carList.getCarList()) {
            car.addDistance();
        }
        ResultView.printResult(carList);
    }

    private List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        int tempCarCount = carCount;
        while (tempCarCount-- > 0) {
            Car car = new Car("");
            carList.add(car);
        }

        return carList;
    }


    protected int setCarCount() {
       Message.askCarCount();
       return InputView.inputOutput();
    }

    protected int setGameCount() {
        Message.askGameCount();
        return InputView.inputOutput();
    }

}
