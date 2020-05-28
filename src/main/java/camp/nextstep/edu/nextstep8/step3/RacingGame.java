package camp.nextstep.edu.nextstep8.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final RacingGameInputView inputView = new RacingGameInputView();
    private static final RacingGameStatusView statusView = new RacingGameStatusView();
    private static final Random RANDOM = new Random();

    public void raceStart() {
        int carNumbers = inputView.getCarNumbers();
        int raceTimes = inputView.getRoundTimes();

        List<RacingCar> participatedList = getParticipatedList(carNumbers);

        for (int i = 0 ; i < raceTimes; i++) {
            for(RacingCar racingCar : participatedList) {
                racingCar.goOrStop(RANDOM.nextInt(10));
            }
            statusView.showRoundResult(participatedList);
        }
    }

    private List<RacingCar> getParticipatedList(int carNumbers) {
        List<RacingCar> participatedList = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++){
            participatedList.add(new RacingCar(i));
        }
        return participatedList;
    }
}
