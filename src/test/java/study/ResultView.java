package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class ResultView {
    private final List<Set<LapResult>> results = new ArrayList<>();
    private final StringBuilder reportContent = new StringBuilder();

    public boolean isCommitted() {
        return !results.isEmpty();
    }

    public void add(Set<LapResult> result) {
        results.add(result);
    }

    public void report() {
        print("실행결과");
        for (int i = 0; i < results.size(); i++) {
            print("\n");
            printRecord(i);
        }
    }

    private void printRecord(int lastLap) {
        Map<Long, List<LapResult>> allCarsLapRecord = results.subList(0, lastLap + 1).stream().flatMap(Set::stream).collect(Collectors.groupingBy(LapResult::getId));
        for (List<LapResult> aCarLap : allCarsLapRecord.values()) {
            printCarLapResult(aCarLap);
        }
    }

    private void printCarLapResult(List<LapResult> aCarLap) {
        for (LapResult lap : aCarLap) {
            printLap(lap);
        }
        print("\n");
    }

    private void printLap(LapResult lap) {
        if (lap.isMoved()) {
            print("-");
        }
    }

    private void print(String content) {
        reportContent.append(content);
    }

    public String getReportContent() {
        return reportContent.toString();
    }
}
