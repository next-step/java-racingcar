package racingCar.view;

import racingCar.domain.Car;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String COMMA = ",";
    private static final String WINNERS_MESSAGE = "가 최종 우승했습니다.";

    public void printExecutionResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printEnter() {
        System.out.println();
    }

    public void printCarDistance(Car car) {
        System.out.print(car.getCarName() + COLON);
        for(int i = 0; i < car.getCarDistance(); i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        for(int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            printComma(winners.size(), i);
        }
        System.out.print(WINNERS_MESSAGE);

    }

    private void printComma(int winnerCount, int index) {
        if(winnerCount != index+1) {
            System.out.print(COMMA);
        }
    }

}
