package racegame;

import java.util.ArrayList;
import java.util.List;

import static racegame.CarView.inputGameCount;
import static racegame.CarView.inputNameList;


public class Main {
    public static void main(String[] args) {
        String[] nameList = inputNameList();
        List<Car> carList = new ArrayList<>();
        for (String carName : nameList) {
            Car car = new Car(carName);
            carList.add(car);
        }
        CarGame carGame = new CarGame(carList);

        int count = inputGameCount();
        for (int i = 0; i < count; i++) {
            carGame.goStepGame();
        }
        carGame.winnerCar();

    }
}
