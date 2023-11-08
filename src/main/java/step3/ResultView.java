package step3;

import java.util.LinkedList;
import java.util.Map;

public class ResultView {
    private final Map<Integer, Integer> resultMap;

    public ResultView(Map<Integer, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public void printResult(char displayChar) {
        for (Integer key : resultMap.keySet()) {
            System.out.print(key + " : ");
            for (int i = 0; i < resultMap.get(key); i++) {
                System.out.print(displayChar);
            }
            System.out.println();
        }
        System.out.println();
    }

}
