package step5.domain.racing;

import step5.domain.racing.cars.Car;
import step5.domain.racing.cars.ScoreBoard;
import step5.domain.strategy.MoveStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By mand2 on 2020-11-07.
 * 해당 경기에 참가할 car 객체 list
 */
public class Cars {

    private final List<Car> cars;
    private final List<ScoreBoard> scoreBoards;
    private final String WINNER_DELIMITER = ",";

    public Cars(List<Car> cars, List<ScoreBoard> scoreBoards) {
        this.cars = cars;
        this.scoreBoards = scoreBoards;
    }

    public static Cars of(String carNames) {
        String[] names = carNames.split(",");
        List<Car> participants = Stream.of(names).map(name -> new Car(name)).collect(toList());
        List<ScoreBoard> scoreBoards = Stream.of(names).map(name -> new ScoreBoard(name)).collect(toList());

        return new Cars(participants, scoreBoards);
    }

    public void runRound(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.forward(moveStrategy);
            addRoundScore(car);
        }
    }

    public void addRoundScore(Car car) {
        this.scoreBoards.stream()
                .filter(s -> s.getName().equals(car.getName()))
                .map(scoreBoard -> scoreBoard.getScoreHistory().add(car.getStep()))
                .collect(toList());
    }

    public List<ScoreBoard> getScoreBoards() {
        return Collections.unmodifiableList(this.scoreBoards);
    }

    public String getWinners() {
        int topStep = getTopStep();
        return cars.stream()
                .filter(car -> car.getStep() == topStep)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private Integer getTopStep() {
        return this.cars.stream()
                .map(c -> c.getStep())
                .max(Integer::compare)
                .get();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj || getClass() != obj.getClass()) return false;
        Cars cars = (Cars) obj;
        return Objects.equals(cars, cars.cars);
    }

}
