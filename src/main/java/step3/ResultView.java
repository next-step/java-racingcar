package step3;


import java.util.List;

public class ResultView {

    private static String PLAY_RESULT = "실행 결과";
    private static String POSITION_OUTPUT_CHARACTER = "-";
    private static String PLAY_ROUND_INFO = "회차";
    private final static String EMPTY = "";

    public void printView(String line) {
        System.out.println(line);
    }

    public void printResultInfo() {
        printView(PLAY_RESULT);
    }

    public void printResult(RacingGame racingGame) {
        List<Car> carList = racingGame.getCarList();
        int roundTime = racingGame.getRoundTime();

        for(int i = 0; i < roundTime; i++) {
            printRoundInfo(i + 1);

            for(Car car: carList) {
                List<Round> roundList = car.getRoundInfoList();

                Round round = roundList.get(i);
                printMoveRecord(round.getPosition());
            }
            printView(EMPTY);
        }
    }

    private void printMoveRecord(int position, String carName) {
        StringBuilder positionOutputBuilder = new StringBuilder();

        positionOutputBuilder.append(carName + ": ");
        for(int i = 0; i < position; i++) {
            positionOutputBuilder.append(POSITION_OUTPUT_CHARACTER);
        }
        printView(positionOutputBuilder.toString());
    }

    private void printRoundInfo(int roundTime) {
        StringBuilder roundOutputBuilder = new StringBuilder();

        roundOutputBuilder.append(roundTime);
        roundOutputBuilder.append(PLAY_ROUND_INFO);

        printView(roundOutputBuilder.toString());
    }



}


