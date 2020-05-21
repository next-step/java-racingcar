package step4.view;

import step4.domain.Record;
import step4.domain.Trace;

import java.util.List;

public class ResultView {

    public void print(List<Record> result, List<String> winners){
        System.out.println("실행 결과");
        for (Record record : result) {
            printResult(record.getTraces());
            System.out.println();
        }
        printWinner(winners);
    }

    private void printWinner(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {
            sb.append(winner).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));

        System.out.println(sb +"가 최종 우승했습니다.");
    }

    private void printResult(List<Trace> traces) {
        for (Trace trace : traces) {
            System.out.print(trace.getName() + " ");
            printPosition(trace.getPosition());
            System.out.println();
        }
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
