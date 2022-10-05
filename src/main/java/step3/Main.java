package step3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carCount = inputView.inputCarCount();
        int raceCount = inputView.inputRaceCount();

        ArrayList<Car> cars = CarStorage.exit(carCount);

        ResultView.resultMessage();

        for(int i=0; i < raceCount; i++){
            Race.start(cars);
            ResultView.displayDash(cars);
        }
    }
}
