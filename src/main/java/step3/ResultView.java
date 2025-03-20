package step3;

import java.util.List;

public class ResultView {
    public void printResults (List<List<String>> finalResults) {
        for (List<String> round : finalResults) {
            for (String s : round) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
