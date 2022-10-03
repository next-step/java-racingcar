package third.logic;

import third.view.InputView;
import third.view.ResultView;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        int raceCount = InputView.inputRaceCount();
        int carCount = InputView.inputCarCount();

        ArrayList<Car> carList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        ResultView.printResultLine();

        for (int i = 0; i < raceCount; i++) {
            Race.startOneRace(carList, carCount);
            ResultView.printOneRace(carList);
        }
    }
}
