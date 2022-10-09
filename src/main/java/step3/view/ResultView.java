package step3.view;

import step3.domain.Car;
import step3.domain.GameInfo;
import step3.domain.Winner;
import step3.util.Separation;

public class ResultView {

    private static final Separation SEPARATION = new Separation();
    private static final String HYPHEN = "-";
    private static final String COLON = " : ";
    private static final String LAST_SENTENCE = " 가 최종 우승 했습니다.";

    public void racingOutput(GameInfo gameInfo) {
        for (Car car : gameInfo.getCarList()) {
            System.out.println(car.getName() + COLON + hyphen(car.getPosition()));
        }
        System.out.println();
    }

    public void winnerOutput(Winner winner) {
        System.out.println(SEPARATION.winnerSeparation(winner) + LAST_SENTENCE);
    }

    private String hyphen(int position) {
        String hyphen = "";
        for (int i = 0; i < position; i++) {
            hyphen += HYPHEN;
        }
        return hyphen;
    }
}
