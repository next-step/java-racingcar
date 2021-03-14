package study.step5;

import study.step5.ui.ResultView;

public class RacingService {
    private Racing racing;

    public RacingService() {
        racing = new Racing();
    }

    public void ready(String input) {
        String[] carNames = input.split(",");
        racing.setUp(carNames);
    }

    public void play(int totalRound) {
        ResultView.printRacingStart();
        for(int i=0; i<totalRound; i++) {
            ResultView.printRacingRound(i+1);
            racing.run();
            ResultView.printRacingResult(racing.getCarList());
        }
        ResultView.printRacingWinner(racing.getWinners());
    }
}
