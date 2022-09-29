package carRacing.view;

import carRacing.domain.RacingHistory;
import carRacing.domain.Record;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final StringBuilder tempPositionString = new StringBuilder();

    public static void displayGameResult(RacingHistory racingHistory){
        // 각 회차 현황 출력
        int lastRound = racingHistory.getLastRound();
        for(int round = 1; round <= lastRound; round++){
            displayRacingState(racingHistory.getRecordList(round));
        }

        // 우승자 출력
        displayRacingWinner(racingHistory.getWinnerRecordList());
    }

    private static void displayRacingState(List<Record> recordList) {
        recordList
                .forEach(car -> System.out.println(car.getName() + " : " + getPositionString(car.getPosition())));
        System.out.println("");
    }

    private static void displayRacingWinner(List<Record> winnerList) {
        tempPositionString.setLength(0);
        String winnerNames = winnerList
                .stream()
                .map(Record::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static String getPositionString(int position) {
        tempPositionString.setLength(0);
        IntStream.range(0, position).forEach(vo -> tempPositionString.append("-"));
        return tempPositionString.toString();
    }

}
