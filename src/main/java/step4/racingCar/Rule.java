package step4.racingCar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Rule {

    private static TreeSet<String> winner = new TreeSet<>();

    public static LinkedHashMap<String, Integer> sortWinner(Map<String, Integer> carList) {
        return carList.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
    }

    public static TreeSet<String> whoIsWinner(Map<String, Integer> carList) {
        LinkedHashMap<String, Integer> sortedCarList = sortWinner(carList);

        int max = sortedCarList.entrySet().iterator().next().getValue(); //정렬된 첫번째 forwardNum 값

        for (Map.Entry<String, Integer> entry : sortedCarList.entrySet()) {
            compareNum(max, entry);
        }
        return winner;
    }

    public static void compareNum(int max, Map.Entry<String, Integer> entry) {
        if (max == entry.getValue()) {
            winner.add(entry.getKey());
        }
    }

}
