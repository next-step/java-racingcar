package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<String> winnerList = new ArrayList<>();

    public void findWinners(Cars cars) {
        winnerList = cars.findWinners();
    }

    public List<String> winners() {
        return winnerList;
    }
}
