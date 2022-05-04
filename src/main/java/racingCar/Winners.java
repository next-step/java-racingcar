package racingCar;

import java.util.List;
import java.util.Objects;

public class Winners {
    private List<Car> winners;

    public Winners(List<Car> winnerList) {
        this.winners = winnerList;
    }

    public String winnersNameList(Cars cars) {
        String winnersNameList = "";
        for (Car winner : this.winners) {
            winnersNameList += winner.toString();
        }
        return winnersNameList.substring(0, winnersNameList.length() - 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}

