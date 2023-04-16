import static view.InputView.inputNumberOfRounds;

import domain.Race;
import view.InputView;
import view.ResultView;

public class main {
    public static void main(String[] args) {
        String[] carName = InputView.inputNameList();
        Race.createCars(carName);
        int numberOfRounds = InputView.inputNumberOfRounds();
        ResultView.outputView(Race.playRace(numberOfRounds));
        ResultView.printWinner(Race.getWinnerList());
    }
}
