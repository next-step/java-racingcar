package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

class ResultView {
    private final List<Set<LapResult>> results = new ArrayList<>();

    public boolean isCommitted() {
        return !results.isEmpty();
    }

    public void add(Set<LapResult> result) {
        results.add(result);
    }

    public void report() {
        print("실행결과");
        for (int i = 0; i < results.size(); i++) {
            printNewline();
            printRecord(i);
        }
    }

    private void printRecord(int lastLap) {
        //@formatter:off
        results.subList(0, lastLap + 1)
                .stream()
                .flatMap(Set::stream)
                .collect(groupingBy(LapResult::getId))
                .values()
                .forEach(this::printCarLapResult);
        //@formatter:on
    }

    private void printCarLapResult(List<LapResult> aCarLap) {
        for (LapResult lap : aCarLap) {
            printLap(lap);
        }
        printNewline();
    }

    private void printLap(LapResult lap) {
        if (lap.isMoved()) {
            print("-");
        }
    }

    protected void print(String content) {
        System.out.print(content);
    }

    private void printNewline() {
        print(System.lineSeparator());
    }
}
