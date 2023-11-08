package step3;

import java.util.HashMap;
import java.util.Map;

public class MoveCarStatus {
    private Map<Integer, Integer> resultMap= new HashMap<>();

    public MoveCarStatus(int cars) {
        //resultMap 초기화
        for (int i = 1; i <= cars; i++) {
            resultMap.put(i, 0);
        }
    }

    public Map<Integer, Integer>  getResultMap() {
        return resultMap;
    }
    public void setResultMap(Map<Integer, Integer> resultMap) {
        this.resultMap = resultMap;
    }
}
