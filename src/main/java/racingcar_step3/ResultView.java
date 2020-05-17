package racingcar_step3;

import java.util.List;

public class ResultView {

    public void print(List<Integer> result) {
        System.out.println("실행 결과 \n");

        for (int positions : result) {
            for (int i = 0; i < positions; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
