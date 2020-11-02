package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

class ResultView {
    private final List<Set<LapResult>> results = new ArrayList<>();

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
                .collect(groupingBy(LapResult::getName, TreeMap::new, toList()))
                .forEach(this::printCarLapResult);
        //@formatter:on
    }

    private void printCarLapResult(String name, List<LapResult> aCarLap) {
        print(nameWithSpace(name) + ": ");
        for (LapResult lap : aCarLap) {
            printLap(lap);
        }
        printNewline();
    }

    public static String nameWithSpace(String name) {
        return String.format("%-5s", name);
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
