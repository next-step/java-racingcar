package step4;

import static step4.Constants.*;

public class ResultView {

    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void printCurrentResult(RacingGame racingGame) {
        String[] carNames = racingGame.getNames();
        int[] carPosition = racingGame.getCarPositions();
        for (int i = 0; i < carNames.length; ++i) {
            System.out.printf("%s : %s\n", carNames[i], makeCarPosition(carPosition[i]));
        }
        System.out.println();
    }

    public String makeCarPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; ++i) {
            stringBuilder.append(POSITION_MARKER);
        }
        return stringBuilder.toString();
    }
}
