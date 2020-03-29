package domain;

import view.OutputView;

import java.util.Random;

public class GameProgress {

    private final int RANDOM_BOUND = 10;
    private final String SPLIT_CHAR = ",";

    public void progress(RacingStadium racingStadium) {
        OutputView outputView = new OutputView();
        System.out.println("실행 결과");

        for (int i = 0; i < racingStadium.getTime(); i++) {
            move(racingStadium);
            outputView.resultView(racingStadium);
            System.out.println("");
        }

        outputView.announceWinners(decisionWinner(racingStadium));
    }

    public void move(RacingStadium racingStadium) {
        Random random = new Random();

        for (int i = 0; i < racingStadium.getCars().length; i++) {
            int ranCount = random.nextInt(RANDOM_BOUND);
            racingStadium.getCars()[i].moveForward(ranCount);
        }
    }

    public String decisionWinner(RacingStadium racingStadium) {
        int max = 0;
        for (int i = 0; i < racingStadium.getCars().length; i++) {
            max = Math.max(racingStadium.getCars()[i].getPosition(), max);
        }

        String winners = "";
        for (int i = 0; i < racingStadium.getCars().length; i++) {
            winners += (racingStadium.getCars()[i].getPosition() == max) ? racingStadium.getCars()[i].getName() + SPLIT_CHAR : "";
        }

        winners = winners.substring(0, winners.length() - 1);

        return winners;
    }

}
