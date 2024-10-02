package racing.result;

import racing.race.RaceRecord;
import racing.race.RaceResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final static String TOP_RANKED_DELIMITER = " , ";

    public void result(int numOfAttempt, RaceResult raceResult) {
        System.out.println("실행 결과");

        String[] results = new String[raceResult.count()];
        Arrays.fill(results, "");
        for (int i = 0; i < numOfAttempt; i++) {
            printRace(raceResult, results, i);
            System.out.println();
        }
        printTopRankedRacers(raceResult);
    }

    private void printRace(RaceResult raceResult, String[] results, int attempt) {
        for (int j = 0; j < raceResult.count(); j++) {
            results[j] += raceResult.raceRecord(j).raceResult(attempt).getResultMark();
            System.out.println(raceResult.raceRecord(j).name() + " : " + results[j]);
        }
    }

    private void printTopRankedRacers(RaceResult raceResult) {
        List<RaceRecord> topRankedRacers = raceResult.topRankedRacers();
        System.out.println("우승자 : "
                + topRankedRacers.stream()
                .map(RaceRecord::name).collect(Collectors.joining(TOP_RANKED_DELIMITER)));
        System.out.println("우승 점수 : " + topRankedRacers.get(0).totalPoint());
    }
}
