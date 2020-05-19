package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int INPUT_ERROR_MIN_NUMBER = 0;
    private static final int START_ROUND = 0;
    private static final String CAR_NAME_SPLITER = ",";

    private int time;
    private List<String> carNames;
    private List<Racingcar> carPositions = new ArrayList<>();
    private Map<Integer, List<Racingcar>> roundResult = new HashMap<>();

    public RacingGame(String carNames, int time) {
        validateCarName(carNames);
        validateTime(time);
        String[] splitCarNames = carNames.split(CAR_NAME_SPLITER);
        this.time = time;
        this.carNames = Arrays.asList(splitCarNames);
    }

    private void validateTime(int time) {
        if (time < INPUT_ERROR_MIN_NUMBER) {
            throw new IllegalArgumentException("value is small than zero");
        }
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("carName is Empty");
        }
    }

    public void start() {
        prepareToRace();
        for (int i = START_ROUND; i < time; i++) {
            move();
            saveRoundResult(i, this.carPositions);
            System.out.println();
        }
    }

    public List<Racingcar> getWinners() {
        List<Racingcar> racingcars = this.carPositions;
        Collections.sort(racingcars);
        Racingcar winRacingcar = racingcars.get(0);
        int winnerPosition = winRacingcar.getCarMovePosition();
        List<Racingcar> winRacingcars = racingcars.stream().filter(car -> car.getCarMovePosition() == winnerPosition).collect(Collectors.toList());
        return winRacingcars;
    }

    public Map<Integer, List<Racingcar>> getRoundResult() {
        return this.roundResult;
    }

    private void saveRoundResult(int round, List<Racingcar> racingcars) {
        this.roundResult.put(round, racingcars);
    }

    private void prepareToRace() {
        for (int i = 0; i < carNames.size(); i++) {
            Racingcar racingcar = createCar(i, carNames.get(i));
            participateRace(racingcar);
        }
    }

    private void move() {
        for (Racingcar racingcar : this.carPositions) {
            racingcar.moveCarMovePosition(new Random());
        }
    }

    private void participateRace(Racingcar racingcar) {
        carPositions.add(racingcar);
    }

    private Racingcar createCar(int number, String carName) {
        return new Racingcar(number, carName);
    }

}