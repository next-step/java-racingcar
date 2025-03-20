package step3;

import java.util.List;

public class ResultView {
    // ResultView:
    // - 최종 결과(List<List<String>>)를 화면에 출력한다.

    public void printResults (List<List<String>> finalResults) {
        for (List<String> round : finalResults) {
            for (String s : round) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
