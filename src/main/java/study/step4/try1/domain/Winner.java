package study.step4.try1.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Winner {

    private static final StringBuilder sb = new StringBuilder();

    private Winner() {
    }

    public static String findWinners(List<Car> resultList) {
        Map<String, Integer> map = setup(resultList);
        Map.Entry<String, Integer> maxEntry = null;
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        boolean flag = true;
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (flag) {
                maxEntry = entry;
                flag = false;
            }
            if (entry.getValue() > maxEntry.getValue()) {
                sb.setLength(0);
                sb.append(entry.getKey()+", ");
                maxEntry = entry;
                continue;
            }
            appendLastComma(maxEntry, entry);
        }
        return sb.toString();
    }

    private static void appendLastComma(Map.Entry<String, Integer> maxEntry, Map.Entry<String, Integer> entry) {
        if (entry.getValue() == maxEntry.getValue()) {
            sb.append(entry.getKey()+", ");
        }
    }

    private static Map<String, Integer> setup(List<Car> resultList) {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : resultList) {
            if (car == null) continue;
            map.put(car.getName(), car.maxPosition());
        }
        return map;
    }
}
