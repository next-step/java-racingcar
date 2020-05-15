package step4.view;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void print(List<Map<String, Integer>> result, List<String> winners){
        System.out.println("실행 결과");
        for (Map<String, Integer> positions : result) {
            printResult(positions);
            System.out.println();
        }
        printWinner(winners);
    }

    private void printWinner(List<String> winners) {
        System.out.println();
        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {
            sb.append(winner).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));

        System.out.println(sb +"가 최종 우승했습니다.");
    }

    private void printResult(Map<String, Integer> positions) {
        for (Map.Entry<String, Integer> position : positions.entrySet()) {
            System.out.print(position.getKey() + " ");
            printPosition(position);
            System.out.println();
        }
    }

    private void printPosition(Map.Entry<String, Integer> position) {
        for (int i = 0; i < position.getValue(); i++) {
            System.out.print("-");
        }
    }
}
