package racing.main;

import racing.domain.Cars;
import racing.domain.Competition;
import racing.domain.RandomMovableCondition;
import racing.exception.CharacterExceedException;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        String[] carNameArr = inputCars();
        int round = InputView.inputNumberOfRounds();

        Competition competition = new Competition(carNameArr, round);
        List<Cars> snapshots = competition.progressEntireRoundAndRecordAllSnapshot(new RandomMovableCondition());
        ResultView.printEntireStatus(snapshots);
        String winners = competition.getWinner(snapshots.get(snapshots.size() - 1));
        ResultView.printWinners(winners);
    }

    private static String[] inputCars() {
        String[] carNameArr;
        while (true) {
            boolean valid = false;
            carNameArr = InputView.inputCars().split(",");
            valid = checkInputOfCars(carNameArr, valid);

            if (valid == true) break;
        }
        return carNameArr;
    }

    private static boolean checkInputOfCars(String[] carNameArr, boolean valid) {
        for (String carName : carNameArr) {
            valid = checkCarNameLength(carName);
        }
        return valid;
    }

    private static boolean checkCarNameLength(String carName) {
        boolean valid = true;
        try {
            if (carName.length() > 5) {
                valid = false;
                throw new CharacterExceedException("자동차 이름은 5글자를 초과할 수 없습니다.");
            }
        } catch (CharacterExceedException e) {
            System.out.println(e.getMessage());
        }
        return valid;
    }


}
