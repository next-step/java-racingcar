package study.step3.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleOutput {

    public void printRaceRecords(List<List<Integer>> roundRecords, String carShape) {
        System.out.println(getConsoleView(roundRecords, carShape));
    }

    private String getConsoleView(List<List<Integer>> roundRecords, String carShape) {
        return roundRecords.stream()
                .map(roundRecord -> drawAllCarPosition(roundRecord, carShape))
                .collect(Collectors.joining());
    }

    private String drawAllCarPosition(List<Integer> roundRecord, String carShape) {
        return roundRecord.stream()
                .map(carPosition -> drawAccumulatedCarPosition(carPosition, carShape))
                .collect(Collectors.joining("\n", "", "\n\n"));
    }

    private String drawAccumulatedCarPosition(int position, String carShape) {
        return IntStream.range(0, position)
                .mapToObj(index -> carShape)
                .collect(Collectors.joining());
    }

}
