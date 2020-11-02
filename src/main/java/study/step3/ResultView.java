package study.step3;

import java.util.*;

import static java.util.stream.Collectors.*;

class ResultView {
    private final List<Set<LapResult>> results = new ArrayList<>();
    private Map<String, List<Boolean>> records;

    public ResultView() {
        this(new HashMap<>());
    }

    public ResultView(Map<String, List<Boolean>> records) {
        this.records = records;
    }

    public void add(Set<LapResult> result) {
        results.add(result);
    }

    public void report() {
        print("실행결과");
        int laps = records.values().iterator().next().size();
        for (int i = 0; i < laps; i++) {
            printNewline();
            printRecord(i);
        }
    }

    private void printRecord(int lastLap) {
        //@formatter:off
        records.forEach((name, record) -> {
            print(nameWithSpace(name) + ": " +
                    record.subList(0, lastLap + 1).stream().map(moved -> moved ? "-" : "").collect(joining()));
            printNewline();
        });
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
