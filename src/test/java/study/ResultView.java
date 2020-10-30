package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class ResultView {
    public static final int CAR_MOVED = 1;
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
        List<Set<LapResult>> allCarsLapRecord = results.subList(0, lastLap + 1);
        for (Set<LapResult> aCarLap : allCarsLapRecord) {
            printCarLapResult(aCarLap);
        }
        print("\n");
    }

    private void printCarLapResult(Set<LapResult> aCarLap) {
        for (LapResult lap : aCarLap) {
            printLap(lap);
        }
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
