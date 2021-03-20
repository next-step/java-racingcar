/*
 * 자동차 경주의 우승자 판별을 결정하는 클래스
 *
 * @author hj-woo
 * @version 2.0
 * */

package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Rule {

    private static TreeSet<Name> winner = new TreeSet<>();

    /*
     * Map 형태의 자동차 이름과 전진 횟수를 받아 전진횟수(value) 순으로 정렬하여 LinkedHashMap을 반환한다.
     * 참고: https://stackoverflow.com/questions/2864840/treemap-sort-by-value
     * */
    public static LinkedHashMap<Name, Position> sortWinner(Map<Name, Position> carList) {
        return carList.entrySet()
                .stream()
                .sorted(Map.Entry.<Name, Position>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
    }

    /*
     * Map 형태의 자동차 이름과 전진 횟수를 받아 우승자 목록을 이름 순으로 정렬한 TreeSet으로 반환한다.
     * */
    public static TreeSet<Name> whoIsWinner(Map<Name, Position> carList) {

        LinkedHashMap<Name, Position> sortedCarList = sortWinner(carList);

        Position maxPosition = sortedCarList.entrySet().iterator().next().getValue(); //정렬된 첫번째 forwardNum 값

        for (Map.Entry<Name, Position> entry : sortedCarList.entrySet()) {
            compareNum(maxPosition, entry);
        }
        return winner;
    }

    /*
     * 최댓값과 현재 entry를 비교해서 공동우승자인 경우엔 winner set에 저장한다.
     * */
    public static void compareNum(Position max, Map.Entry<Name, Position> entry) {
        if (max.equals(entry.getValue())) {
            winner.add(entry.getKey());
        }
    }

}
