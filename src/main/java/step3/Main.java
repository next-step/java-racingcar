package step3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] carNames = inputView.inputCarName().split(",");
        CarValidator.nameValidator(carNames);
        int raceCount = inputView.inputRaceCount();

        ArrayList<Car> cars = CarStorage.exit(carNames);

        ResultView.resultMessage();

        for(int i=0; i < raceCount; i++){
            Race.start(cars);
            ResultView.displayDash(cars);
        }
        ResultView.displayWinners(Race.getWinners(cars));
    }
}
