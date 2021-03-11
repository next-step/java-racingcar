package racingcar;

import java.util.List;

public class ResultView {
    private static final String RESULT_HEAD_MESSAGE = "실행결과";
    private static final String RESULT_BODY_MESSAGE_COLON = " : ";
    private static final String RESULT_BODY_MESSAGE_HYPHEN = "-";
    private static final String RESULT_TAIL_MESSAGE = "가 최종 우승했습니다.";

    public void printResult(GameResult gameResult) {
        printHead();
        for (List<Car> carList : gameResult.getGameResultList()) {
            printStepResult(carList);
        }
        printTail(gameResult.getWinners());
    }

    private void printStepResult(List<Car> carList) {
        for (Car car : carList) {
            printPosition(car);
        }
        printEmptyLine();
    }

    private void printHead() {
        System.out.println(RESULT_HEAD_MESSAGE);
    }

    private void printPosition(Car car) {
        System.out.print(car.getCarName() + RESULT_BODY_MESSAGE_COLON + " ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(RESULT_BODY_MESSAGE_HYPHEN);
        }
        printEmptyLine();
    }

    private void printTail(List<String> winners) {
        String winnersName = addCommaWinners(winners);
        System.out.println(winnersName + RESULT_TAIL_MESSAGE);

    }

    private String addCommaWinners(List<String> winners) {
        StringBuffer sb = new StringBuffer();

        int winnerSize = winners.size();
        for (int i = 0; i < winnerSize; i++) {
            sb.append(winners.get(i));
            if (i != (winnerSize - 1)) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private void printEmptyLine() {
        System.out.println();
    }

}
