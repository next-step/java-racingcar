package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Name> winnerList = new ArrayList<>();

    public List<Name> findWinners(Cars cars) {
        winnerList = cars.findWinners();
        return winnerList;
    }
}
