package racinggame.domain.winner;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.history.CarHistory;

public class Winners {

    private final List<Winner> winnerList = new ArrayList<>();

    public Winners(final List<CarHistory> carHistories, final int maxLocation) {
        for (CarHistory carHistory : carHistories) {
            if (carHistory.isInLocation(maxLocation)) {
                winnerList.add(new Winner(carHistory.getCarName()));
            }
        }
    }

    public List<Winner> getWinners() {
        return new ArrayList<>(winnerList);
    }

}
