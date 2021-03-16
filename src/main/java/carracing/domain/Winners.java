package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> winnerList;

    public Winners(List<Car> winnerList) {
        this.winnerList = winnerList;
    }

    public List<Car> getWinnerList() {
        return winnerList;
    }

    public List<String> getNameList() {
        List<String> nameList = new ArrayList<>();
        for (Car car : winnerList) {
            nameList.add(car.inquiryRacingScore().getCarName());
        }
        return nameList;
    }
}
