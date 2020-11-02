package study.step3;

import java.util.*;

import static java.util.stream.Collectors.*;

class ResultView {
    private final Map<String, List<Boolean>> records;

    public ResultView() {
        this(new HashMap<>());
    }

    public ResultView(Map<String, List<Boolean>> records) {
        this.records = records;
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
        new TreeMap<>(records).forEach((name, record) -> {
            printNameAndRecord(name, record.subList(0, lastLap + 1));
            printNewline();
        });
    }

    private void printNameAndRecord(String name, List<Boolean> recoard) {
        //@formatter:off
        print(nameWithSpace(name) + ": " +
                recoard.stream()
                        .map(moved -> moved ? "-" : "")
                        .collect(joining())
        );
        //@formatter:on
    }

    public static String nameWithSpace(String name) {
        return String.format("%-5s", name);
    }

    protected void print(String content) {
        System.out.print(content);
    }

    private void printNewline() {
        print(System.lineSeparator());
    }
}
