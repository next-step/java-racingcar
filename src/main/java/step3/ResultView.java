package step3;

import java.util.LinkedList;
import java.util.Map;

public class ResultView {
    private final Map<Integer, LinkedList<String>> resultMap;

    public ResultView(Map<Integer, LinkedList<String>> resultMap) {
        this.resultMap = resultMap;
    }

    public void printResult() {

        for (Integer key : resultMap.keySet()) {
            System.out.print(key + " : ");
            for (String value : resultMap.get(key)) {
                System.out.print(value);
            }
            System.out.println();
        }
        System.out.println();
    }

}
