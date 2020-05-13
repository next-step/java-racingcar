package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameManager {

    private List<RacingCar> racingCarList;

    public RacingGameManager() {
        // TODO: InputView,ResultView 생성
    }

    public void start(int carCount, int moveCount) {
        // TODO: InputView를 통해서 자동차 대수와 시도할 횟수를 가져온다.

        generateRaceingCar(carCount);
        moveRacingCar(moveCount);
    }

    private void generateRaceingCar(int generateCount) {
        this.racingCarList = IntStream.range(0, generateCount)
                .mapToObj(i -> new RacingCar())
                .collect(Collectors.toList());
    }

    private void moveRacingCar(int moveCount) {
        IntStream.range(0, moveCount).forEach(i ->
                this.racingCarList.forEach(racingCar -> racingCar.move(RandomMoveFactory.getInstance())));
    }

    public void end() {
        // TODO: ResultView를 통해서 결과를 출력
    }
}
