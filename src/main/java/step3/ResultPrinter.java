package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultPrinter {

    private final String PROCESS_BAR = "-";

    private final String END_OF_ROUND_MESSAGE = "";

    private final String WINNER_SUFFIX = "가 최종 우승했습니다.";

    private final int iterate;

    public ResultPrinter(int iterate) {
        this.iterate = iterate;
    }

    public void printRecord(List<Car> cars) {
        System.out.println("실행 결과");
        Map<String, List<String>> processBarRecords = this.recordConvertToProcessBar(cars);
        for (int i = 0; i < this.iterate; i++) {
            this.printRoundRecord(processBarRecords, i);
            this.printEndMessageOfRound(i);
        }
    }

    public void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + WINNER_SUFFIX);
    }

    private Map<String, List<String>> recordConvertToProcessBar(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    List<String> processBarRecord = car.getRacingRecord().stream()
                            .map(PROCESS_BAR::repeat)
                            .collect(Collectors.toList());
                    return Map.entry(car.getName(), processBarRecord);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void printRoundRecord(Map<String, List<String>> processBarRecords, int round) {
        for( Map.Entry<String, List<String>> entry : processBarRecords.entrySet() ){
            String carName = entry.getKey();
            String processBarRecord = entry.getValue().get(round);
            System.out.println(carName + " : " + processBarRecord);
        }
    }

    private void printEndMessageOfRound(int round) {
        System.out.println(this.END_OF_ROUND_MESSAGE);
    }
}
