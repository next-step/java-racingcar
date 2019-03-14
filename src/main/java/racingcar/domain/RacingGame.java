package racingcar.domain;

import racingcar.random.PositiveIntUnder10Generator;
import racingcar.random.RandomIntGenerator;
import racingcar.vo.RacingGameParameter;
import racingcar.vo.RacingGameRound;
import racingcar.vo.RacingResultOfRound;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private RacingGameInfo racingGameInfo;

    public RacingGame(RacingGameParameter parameter) {
        this(parameter, new PositiveIntUnder10Generator());
    }

    public RacingGame(RacingGameParameter parameter, RandomIntGenerator randomIntGenerator) {
        RacingCarGroup racingCarGroup = racingCarGroupSetUp(parameter.getCarNames(), randomIntGenerator);
        RacingGameRound racingGameRound = new RacingGameRound(parameter.getTotalRound());

        this.racingGameInfo = new RacingGameInfo(racingCarGroup, racingGameRound);
    }

    private RacingCarGroup racingCarGroupSetUp(List<String> carNames, RandomIntGenerator randomIntGenerator) {
        return new RacingCarGroup(carSetUp(carNames), randomIntGenerator);
    }

    private List<Car> carSetUp(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getTotalRound() {
        return this.racingGameInfo
                .getRacingGameRound()
                .getTotalRound();
    }

    public int getCurrentRound() {
        return this.racingGameInfo
                .getRacingGameRound()
                .getCurrentRound();
    }

    public List<Car> getCars() {
        return this.racingGameInfo.getCars();
    }

    public RacingResultOfRound race() {
        if (isEnd()) {
            throw new IllegalStateException("종료된 경주 입니다. 초기화를 해주세요.");
        }

        moveCars();

        RacingResultOfRound racingResultOfRound = new RacingResultOfRound(copyCarList(), getCurrentRound());
        this.racingGameInfo.incrementCurrentRound();

        return racingResultOfRound;
    }

    private void moveCars() {
        this.racingGameInfo.moveCars();
    }

    private List<Car> copyCarList() {
        List<Car> originalCars = getCars();

        return originalCars.stream()
                .map(Car::copy)
                .collect(Collectors.toList());
    }

    public boolean isEnd() {
        return !this.racingGameInfo.hasNextRound();
    }

    public void initializeRacingGame() {
        this.racingGameInfo.initialize();
    }
}