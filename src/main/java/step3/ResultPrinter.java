package step3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultPrinter {

    private final String PROCESS_BAR = "-";

    private final String WINNER_SUFFIX = "가 최종 우승했습니다.";

    private final int iterate;

    public ResultPrinter(int iterate) {
        this.iterate = iterate;
    }

    public void printRecord(List<Car> cars) {
        System.out.println("실행 결과");
        Map<String, ProcessBar> processBarRecords = this.recordConvertToProcessBar(cars);
        for (int i = 0; i < this.iterate; i++) {
            this.printRoundRecord(processBarRecords, i);
            this.printEndMessageOfRound(i);
        }
    }

    public void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + WINNER_SUFFIX);
    }

    private Map<String, ProcessBar> recordConvertToProcessBar(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    List<String> bars = car.getRacingRecord().stream()
                            .map(PROCESS_BAR::repeat)
                            .collect(Collectors.toList());
                    ProcessBar processBar = new ProcessBar(bars);
                    return Map.entry(car.getName(), processBar);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void printRoundRecord(Map<String, ProcessBar> processBarRecords, int round) {
        for( Map.Entry<String, ProcessBar> entry : processBarRecords.entrySet() ){
            String carName = entry.getKey();
            String processBarRecord = entry.getValue().getBars().get(round);
            System.out.println(carName + " : " + processBarRecord);
        }
    }

    private void printEndMessageOfRound(int round) {
        String END_OF_ROUND_MESSAGE = "";
        System.out.println(END_OF_ROUND_MESSAGE);
    }
}
