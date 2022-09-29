package racing;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String TITLE = "실행 결과";

    public void print(Map<Integer, List> result) {
        printBlank();
        printTitle();
        for(int i = 1 ; i < result.size() ; i++) {
            printResult(result.get(i));
        }
    }

    private void printTitle() {
        System.out.println(TITLE);
    }

    private void printBlank() {
        System.out.println();
    }

    private void printResult(List<Integer> positions) {
        for (int i = 0 ; i < positions.size() ; i++) {
            printPosition(positions.get(i));
        }
        System.out.println();
    }

    private void printPosition(int num) {
        for(int i=0 ; i<num ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }


}
