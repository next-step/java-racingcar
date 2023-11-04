package step3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ServiceLogic {

    private final Map<Integer, LinkedList<String>> resultMap;
    private final ResultView resultView;

    public ServiceLogic() {
        resultMap = new HashMap<>();
        resultView = new ResultView(resultMap);
    }

    public void process(int carNumber, int tryCount) {
        // 자동차 대수만큼 resultMap을 초기화
        for (int i = 0; i < carNumber; i++) {
            resultMap.put(i, new LinkedList<>());
        }

        // tryCount만큼 자동차를 이동시킴
        for (int i = 0; i < tryCount; i++) {
            moveCars(carNumber);

            // 결과를 출력
            resultView.printResult();
        }


    }

    private void moveCars(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            int randomValue = (int) (Math.random() * 10);
            if (randomValue >= 4) {
                resultMap.get(i).add("-");
            }
        }
    }
}
