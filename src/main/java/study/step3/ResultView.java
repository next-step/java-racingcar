package study.step3;

import study.step3.domain.CarRacing;
import study.step3.domain.RaceRecord;

import java.util.*;

import static java.util.stream.Collectors.joining;

class ResultView {
    private final RaceRecord raceRecord;
    private final Set<String> winners;

    public ResultView(RaceRecord raceRecord, Set<String> winners) {
        this.winners = winners;
        this.raceRecord = raceRecord;
    }

    public ResultView(CarRacing carRacing) {
        this(carRacing.getRecords(), carRacing.getWinners());
    }

    public void report() {
        print("실행결과");
        printRaceHistory();
        printWinners();
    }

    void printRaceHistory() {
        int laps = raceRecord.getTotalTry();
        for (int i = 1; i <= laps; i++) {
            printNewline();
            printRecord(i);
        }
    }

    void printWinners() {
        String names = winners.stream() //
                .sorted() //
                .map(name -> "'" + name + "'")
                .collect(joining(", "));
        print("우승자는 " + names + " 입니다.");
    }

    private void printRecord(int lastLap) {
        raceRecord.forEachRecordUntil(lastLap, (name, record) -> {
            printNameAndRecord(name, record);
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
