package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultPrinter {

    private final String PROCESS_BAR = "-";

    public void print(int iterate, List<List<Integer>> racingRecords) {
        System.out.println("실행 결과");
        List<List<String>> processBarRecords = this.convertProcessBar(racingRecords);
        for (int i = 0; i < iterate; i++) {
            if (i != 0) {
                System.out.println("");
            }
            for (List<String> processBarRecord : processBarRecords) {
                System.out.println(processBarRecord.get(i));
            }
        }
    }

    private List<List<String>> convertProcessBar(List<List<Integer>> racingRecords) {
        return racingRecords.stream().map(
                racingRecord -> racingRecord.stream()
                        .map(PROCESS_BAR::repeat)
                        .collect(Collectors.toList())
        ).collect(Collectors.toList());
    }

    private Stream<List<Integer>> parseToRecord(ArrayList<Participant> participants) {
        return participants.stream().map(Participant::getRacingRecord);
    }
}
