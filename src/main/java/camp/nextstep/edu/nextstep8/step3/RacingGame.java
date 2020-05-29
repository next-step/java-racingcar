package camp.nextstep.edu.nextstep8.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final Random RANDOM = new Random();
    private RacingGameInputView inputView = new RacingGameInputView();
    private RacingGameStatusView statusView = new RacingGameStatusView();

    public void play() {
        int carNumbers = inputView.getCarNumbers();
        int raceTimes = inputView.getRoundTimes();
        raceStart(raceTimes, enrollAndGetParticipatedList(carNumbers));
    }

    public List<RacingCar> enrollAndGetParticipatedList(int carNumbers) {
        List<RacingCar> participatedList = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++){
            participatedList.add(new RacingCar(i));
        }
        return participatedList;
    }

    public void raceStart(int raceTimes, List<RacingCar> participatedList) {
        for (int i = 0 ; i < raceTimes; i++) {
            for(RacingCar racingCar : participatedList) {
                racingCar.goOrStop(RANDOM.nextInt(10));
            }
            statusView.showRoundResult(participatedList);
        }
    }
}
