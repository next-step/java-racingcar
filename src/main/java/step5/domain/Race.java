package step5.domain;

import step5.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private static int round;
    private static List<CarRacer> carRacers;
    private static ResultView resultView = new ResultView();
    private static String maxCarName;
    private static int maxCarPosition = 0;

    public Race(String[] carNames, int round) {
        carRacers = enroll(carNames);
        this.round = round;
    }

    private List<CarRacer> enroll(String[] carNames) {
        return Arrays.stream(carNames)
                .map(CarRacer::new)
                .collect(Collectors.toList());
    }

    public void startGame() {
        resultView.printCurrState(carRacers);
        runGameByCycle();
        carRacers.stream()
                .forEach(carRacer -> findMaxPositionCarName(carRacer.getCarName(),carRacer.getCurrPosition()));
        resultView.printFinalResult(maxCarName);
    }

    private void runGameByCycle() {
        for (int i = 0; i < round; i++) {
            playOneRound();
            resultView.printCurrState(carRacers);
        }
    }

    private void playOneRound() {
        for (CarRacer carRacer: carRacers) {
            carRacer.canIGo();
        }
    }



    public void findMaxPositionCarName(String carName, int carPosition) {
        if (carPosition > maxCarPosition) {
            maxCarName = carName;
            maxCarPosition = carPosition;
            return;
        }
        if (carPosition == maxCarPosition) {
            maxCarName += ", "+carName;
            return;
        }
    }
}
