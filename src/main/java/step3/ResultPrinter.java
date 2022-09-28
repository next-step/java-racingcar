package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultPrinter {

    private final String PROCESS_BAR = "-";
    private final String END_OF_ROUND_MESSAGE = "";

    private final int iterate;

    public ResultPrinter(int iterate) {
        this.iterate = iterate;
    }

    public void print(List<Car> cars) {
        System.out.println("실행 결과");
        List<List<String>> processBarRecords = this.convertProcessBar(cars);
        for (int i = 0; i < this.iterate; i++) {
            for (List<String> processBarRecord : processBarRecords) {
                System.out.println(processBarRecord.get(i));
            }
            this.printEndMessageOfRound(i);
        }
    }

    private void printEndMessageOfRound(int round) {
        if (!this.isLastRound(round)) {
            System.out.println(this.END_OF_ROUND_MESSAGE);
        }
    }

    private boolean isLastRound(int round) {
        return round == this.iterate - 1;
    }

    private List<List<String>> convertProcessBar(List<Car> cars) {
        return cars.stream().map(
                car -> car.getRacingRecord().stream()
                        .map(PROCESS_BAR::repeat)
                        .collect(Collectors.toList())
        ).collect(Collectors.toList());
    }
}
