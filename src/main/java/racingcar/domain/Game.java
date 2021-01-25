package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import racingcar.domain.Car;
import racingcar.util.PrintUtils;
import racingcar.util.RandomUtils;

@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private int gameCnt;
    private List<Car> carList;

    public int getGameCnt() {
        return gameCnt;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinner() {
        Optional<Car> maxPositionCar = carList
            .stream()
            .max((a, b) -> Integer.compare(a.getPosition(), b.getPosition()));
        return returnWinner(maxPositionCar.get().getPosition());
    }

    private List<String> returnWinner(final int winnerThreshold) {
        List<String> winnerList = new ArrayList<>();
        carList
            .stream()
            .filter(car -> winnerThreshold == car.getPosition())
            .forEach(winner -> winnerList.add(winner.getName()));
        return winnerList;
    }

    public void play() {
        PrintUtils.printExecutionResult();
        for (int i = 0; i < gameCnt; i++) {
            carList.stream().forEach(car -> {
                int carRandomNum = RandomUtils.nextInt(
                        Constant.RANDOM_START_INCLUSIVE,
                        Constant.RANDOM_END_INCLUSIVE);
                checkMove(car, carRandomNum);
            });
            PrintUtils.printCarStep(carList);
        }
    }

    public void checkMove(Car car, int randomNum) {
        if (randomNum >= Constant.MOVE_THRESHOLD) {
            car.updatePosition();
        }
    }
}
