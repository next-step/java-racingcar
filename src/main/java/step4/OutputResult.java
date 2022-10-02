package step4;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputResult {

    public void outputRound(Map<String, Integer> positions) {
        for(Entry<String, Integer> position : positions.entrySet()) {
            System.out.println(position.getKey() + " : " + printBar(position.getValue()));
        }
        System.out.println();
    }

    private String printBar(int value) {
        String result = "";
        for(int i = 0 ; i < value ; i++) {
            result += "-";
        }
        return result;
    }

    public void printResult(List<String> winners) {

        System.out.print(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public void printTitle() {
        System.out.println("\n실행 결과");
    }
}
