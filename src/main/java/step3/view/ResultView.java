package step3.view;

import step3.domain.Car;

import java.util.List;

public class ResultView {
    private final String RESULT_TITLE = "실행 결과";
    private final String POSITION_MARKER = "-";
    private StringBuilder sb = new StringBuilder();

    public void printTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void printRoundCarPosition(int[] distances) {
        for (int distance : distances) {
            printCarDistance(distance);
        }
        System.out.println();
    }

    public void printRoundCarPositionWithName(List<Car> cars, int[] distance) {
        for(int i = 0 ;i <cars.size();i++) {
            printCarName(cars.get(i).getName());
            printCarDistance(distance[i]);
        }
        System.out.println();
    }

    public void printRacingWinner(List<String> winners) {
        String makeWinnerSentence = makeWinnerSentence(winners);
        System.out.println(makeWinnerSentence);
    }

    private String makeWinnerSentence(List<String> winners) {
        sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            appendComma(i);
            sb.append(winners.get(i));
        }
        sb.append("가 최종 우승했습니다.");
        return sb.toString();
    }

    private void appendComma(int index) {
        if(index != 0)
            sb.append(", ");
    }
    private void printCarDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(POSITION_MARKER);
        }
        System.out.println();
    }

    private void printCarName(String name) {
        System.out.print(name+" : ");
    }
}
