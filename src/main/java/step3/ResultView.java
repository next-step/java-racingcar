package step3;

import java.util.List;

public class ResultView {

    List<int[]> result;

    public ResultView(List<int[]> resultStack) {
        this.result = resultStack;
    }

    public void showResult() {
        System.out.println("실행결과");
        for(int i = 0; i<result.size(); i++) {
            printPosition(result.get(i));
            System.out.println("");
        }
    }

    private void printPosition(int[] positions) {
        for(int i=0; i<positions.length; i++) {
            for(int j = 0; j<positions[i]+1; j++) {
                System.out.print("-");
            }
            System.out.println("");
        }
    }
}
