package step3;


import java.util.List;

public class ResultView {

    private final static String PLAY_RESULT = "실행 결과";
    private final static String POSITION_OUTPUT_CHARACTER = "-";
    private final static String PLAY_ROUND_INFO = "회차";
    private final static String EMPTY = "";
    private final static String WINNER_NAME_INFO = "가 최종 우승했습니다.";

    public void printView(String line) {
        System.out.println(line);
    }

    public void printResultInfo() {
        printView(PLAY_RESULT);
    }

    public void printResult(RacingGame racingGame) {
        Cars cars = racingGame.getCars();
        int roundTime = racingGame.getRoundTime();

        for(int i = 0; i < roundTime; i++) {
            printRoundInfo(i + 1);

            CarsIterator carsIterator = new CarsIterator(cars);

            while(carsIterator.hasNext()) {
                Car car = carsIterator.next();

                List<Round> roundList = car.getRoundInfoList();

                Round round = roundList.get(i);
                printMoveRecord(round.getPosition(), car.getCarName());
            }
            printView(EMPTY);
        }
        printWinner(cars.getWinnerNames());
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

    private void printWinner(List<String> winnerNameList) {
        StringBuilder winnerOutputBuilder = new StringBuilder();

        for(int i = 0; i < winnerNameList.size(); i++) {
            if(i != 0) {
                winnerOutputBuilder.append(",");
            }
            winnerOutputBuilder.append(winnerNameList.get(i));
        }
        winnerOutputBuilder.append(WINNER_NAME_INFO);
        printView(winnerOutputBuilder.toString());
    }


}


