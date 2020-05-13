package step3.view;

import java.util.List;

public class ResultView {

    public void print(List<int[]> result){
        System.out.println("실행 결과");

        for (int[] positions : result) {

            printResult(positions);
        }
    }

    private void printResult(int[] positions) {
        for (int position : positions) {
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
