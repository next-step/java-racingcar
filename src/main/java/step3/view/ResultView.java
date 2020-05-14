package step3.view;

import java.util.List;

public class ResultView {

    public void print(List<int[]> result){
        System.out.println("실행 결과");

        for (int[] positions : result) {
            printResult(positions);
            System.out.println();
        }
    }

    private void printResult(int[] positions) {
        for (int position : positions) {
            printPosition(position);
            System.out.println();
        }
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
