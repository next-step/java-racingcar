package racing.result;

import racing.race.RaceRecord;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final static String TOP_RANKED_DELIMITER = " , ";

    public void result(int numOfAttempt, List<RaceRecord> raceRecords) {
        System.out.println("실행 결과");

        String[] results = new String[raceRecords.size()];
        Arrays.fill(results, "");
        for (int i = 0; i < numOfAttempt; i++) {
            printRace(raceRecords, results, i);
            System.out.println();
        }
        printTopRankedRacers(raceRecords);
    }

    private void printRace(List<RaceRecord> raceRecords, String[] results, int attempt) {
        for (int j = 0; j < raceRecords.size(); j++) {
            results[j] += raceRecords.get(j).raceResult(attempt).getResultMark();
            System.out.println(raceRecords.get(j).name() + " : " + results[j]);
        }
    }

    private void printTopRankedRacers(List<RaceRecord> raceRecords) {
        int topRanked = raceRecords.stream()
                .max(Comparator.comparingInt(RaceRecord::totalPoint)).orElseThrow().totalPoint();

        String topRankedRacers = raceRecords.stream()
                .filter(raceRecord -> raceRecord.totalPoint() == topRanked)
                .map(RaceRecord::name)
                .collect(Collectors.joining(TOP_RANKED_DELIMITER));

        System.out.println("우승자 : " + topRankedRacers);
        System.out.println("우승 점수 : " + topRanked);
    }
}
