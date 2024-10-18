package racinggamewinner.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WinnerList {
    List<String> winnerNameList;

    public WinnerList(List<String> winnerNameList) {
        this.winnerNameList = winnerNameList;
    }

    public List<String> findWinner(Map<String, Integer> carNameAndPositionMap, int maxCarPosition) {
        addWinnerNameToList(carNameAndPositionMap,maxCarPosition);
        return winnerNameList;
    }

    public void addWinnerNameToList(Map<String, Integer> carNameAndPositionMap, int maxCarPosition) {
        carNameAndPositionMap.keySet()
                .stream()
                .filter(carName -> carNameAndPositionMap.get(carName) == maxCarPosition)
                .forEachOrdered(carName -> winnerNameList.add(carName));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerList that = (WinnerList) o;
        return Objects.equals(winnerNameList, that.winnerNameList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winnerNameList);
    }
}
