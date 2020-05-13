package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameManager {

    private List<RacingCar> racingCarList;
    private final InputView inputView = new InputView();

    public RacingGameManager() {
    }

    public void start() {
        inputView.show();

        generateRaceingCar(inputView.getRacingCarCount());
        moveRacingCar(inputView.getMoveCount());
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
