package racing.view.result;

import racing.constant.RacePosition;
import racing.domain.RaceRecord;
import racing.domain.RaceResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private final static String TOP_RANKED_DELIMITER = " , ";

    public void result(int numOfAttempt, RaceResult raceResult) {
        System.out.println("실행 결과");

        for (int i = 0; i < numOfAttempt; i++) {
            printRace(raceResult, i);
            System.out.println();
        }
        printTopRankedRacers(raceResult);
    }

    private void printRace(RaceResult raceResult, int attempt) {
        for (int i = 0; i < raceResult.count(); i++) {
            int position = raceResult.raceRecord(i).raceResult(attempt);
            System.out.println(raceResult.raceRecord(i).name() + " : " + raceMark(position));
        }
    }

    private String raceMark(int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> RacePosition.FORWARD.getResultMark()).collect(Collectors.joining());
    }

    private void printTopRankedRacers(RaceResult raceResult) {
        List<RaceRecord> topRankedRacers = raceResult.topRankedRacers();
        System.out.println("우승자 : "
                + topRankedRacers.stream()
                .map(RaceRecord::name).collect(Collectors.joining(TOP_RANKED_DELIMITER)));
        System.out.println("우승 점수 : " + topRankedRacers.get(0).totalPoint());
    }
}
