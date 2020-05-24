package game.domain;

import game.view.RacingGameInputView;
import game.view.RacingGameResultView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private static final int INIT_POSITION = 0;
    private static final int ROUND_COMMENT_OFFSET = 1;

    private final MovePolicy movePolicy;
    private final RacingGameInputView racingGameInputView;
    private final RacingGameResultView racingGameResultView;

    public RacingGame(MovePolicy movePolicy, RacingGameInputView racingGameInputView, RacingGameResultView racingGameResultView) {
        this.movePolicy = movePolicy;
        this.racingGameInputView = racingGameInputView;
        this.racingGameResultView = racingGameResultView;
    }

    public void play() {
        List<Car> carList = setUpCarList();
        int time = setUpTime();

        IntStream.range(0, time).forEach(i -> playOnce(i, carList));

        announceWinner(carList);
    }

    private List<Car> setUpCarList() {
        List<CarName> carNameList = racingGameInputView.getCarNameList();
        return carNameList.stream().map(carName ->
            new Car(carName, INIT_POSITION, movePolicy)
        ).collect(Collectors.toList());
    }

    private int setUpTime() {
        return racingGameInputView.getTime();
    }

    private void playOnce(int round, List<Car> carList) {
        racingGameResultView.printRound(round + ROUND_COMMENT_OFFSET);
        carList.forEach(Car::move);
        carList.forEach(racingGameResultView::printResult);
    }

    private void announceWinner(List<Car> carList) {
        int winScore = carList.stream().max(Comparator.comparingInt(Car::getPosition)).map(Car::getPosition).orElse(INIT_POSITION);
        racingGameResultView.announceWinner(carList.stream().filter(c -> c.getPosition() >= winScore).collect(Collectors.toList()));
    }
}
