package step3.domain;

import step3.service.Randomize;
import step3.service.ScoreInspector;

import javax.naming.Name;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Car> participants = Stream.of(names).map(s -> new Car(s)).collect(toList());
        List<ScoreBoard> scoreBoards = Stream.of(names).map(s -> new ScoreBoard(s)).collect(toList());

        return new Cars(participants, scoreBoards);
    }

    // 1 round 때마다 각 car score . 해당 score가 move 인지 아닌지 판단 -> move. 점수
    public void runRound(Randomize randomize) {
        for (int i = 0; i < cars.size(); i++) {
            int score = randomize.random();
            int step = ScoreInspector.judgeMovable(score);
            cars.get(i).forward(step);
        }
    }

    public List<ScoreBoard> getRoundScore() {
        for (Car car : cars) {
            scoreBoards.stream()
                    .filter(s -> s.getName().equals(car.getName()))
                    .map(scoreBoard -> scoreBoard.getScoreHistory().add(car.getStep()))
                    .collect(toList());
        }
        return scoreBoards;
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
        return cars;
    }

    public int carNum() {
        return this.cars.size();
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
