import step3.InputDto;
import step3.InputView;
import step3.RacingCar;
import step3.ResultView;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputDto input = inputView.getInput();
        ResultView resultView = new ResultView();

        ArrayList<String> nameList = input.getNameList();
        ArrayList<RacingCar> carList = nameList
                .stream()
                .map(RacingCar::new)
                .collect(Collectors.toCollection(ArrayList::new));


        resultView.printStart();

        for (int i = 0; i < input.getNumberOfTrial(); i++) {
            for (RacingCar racingCar : carList) {
                String carName = racingCar.getCarName();
                int moveCount = racingCar.move();
                resultView.printRacingCar(carName, moveCount);
            }
            System.out.println();
        }

        resultView.lastPrint(carList);
    }
}
