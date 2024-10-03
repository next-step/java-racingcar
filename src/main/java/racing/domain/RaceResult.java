package racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceResult {

    private final List<RaceRecord> raceRecords;

    public RaceResult(List<RaceRecord> raceRecords) {
        this.raceRecords = List.of(raceRecords.toArray(new RaceRecord[0]));
    }

    public int count() {
        return raceRecords.size();
    }

    public RaceRecord raceRecord(int index) {
        return raceRecords.get(index);
    }

    public Stream<RaceRecord> stream() {
        return raceRecords.stream();
    }

    public List<RaceRecord> topRankedRacers() {
        int topRanked = topRankedPoint();

        return raceRecords.stream()
                .filter(raceRecord -> raceRecord.totalPoint() == topRanked)
                .collect(Collectors.toUnmodifiableList());
    }

    private int topRankedPoint() {
        return raceRecords.stream()
                .max(Comparator.comparingInt(RaceRecord::totalPoint)).orElseThrow().totalPoint();
    }
}
