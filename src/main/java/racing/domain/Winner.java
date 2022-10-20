package racing.domain;

import racing.utils.SplitUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {

    private final List<Car> carList;
    private static final int MAX_POSITION_IDX = 0;

    public Winner(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> findWinners() {
        return findWinners(findMaxPosition());
    }

    private List<Car> findWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if(!car.isWinner(maxPosition)) {
                break;
            }
            winners.add(car);
        }
        return winners;
    }

    public String findWinnersName() {
        return findWinnersName(findMaxPosition());
    }

    private String findWinnersName(Position maxPosition) {
        List<String> winnersName = new ArrayList<>();
        for (Car car : carList) {
            if(!car.isWinner(maxPosition)) {
                break;
            }
            winnersName.add(car.getName());
        }
        return SplitUtil.listToStr(winnersName);
    }

    public Position findMaxPosition() {
        Collections.sort(carList);
        return carList.get(MAX_POSITION_IDX).getPosition();
    }
}
