package step4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    List<RacingCar> carList;

    public Winner(List<RacingCar> carList) {
        this.carList = carList;
    }

    private int getMaxMoveCount() {
        return carList
                .stream()
                .max(Comparator.comparing(RacingCar::getMoveCount))
                .get().getMoveCount();
    }

    public String getWinnerList() {
        int maxMoveCount = getMaxMoveCount();

        List<String> winnerList = carList
                .stream()
                .filter(racingCar -> racingCar.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList())
                .stream().map(RacingCar::getCarName).collect(Collectors.toList());

        return String.join(", ", winnerList);

    }
}
