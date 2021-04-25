package step4;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputDto input = inputView.getInput();
        ResultView resultView = new ResultView();

        List<String> nameList = input.getNameList();
        List<RacingCar> carList = nameList
                .stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());


        resultView.printStart();

        for (int i = 0; i < input.getNumberOfTrial(); i++) {
            for (RacingCar racingCar : carList) {
                String carName = racingCar.getCarName();
                int moveCount = racingCar.move();
                resultView.printRacingCar(carName, moveCount);
            }
            System.out.println();
        }

        Winner winner = new Winner(carList);
        resultView.lastPrint(winner.getWinnerList());
    }
}
