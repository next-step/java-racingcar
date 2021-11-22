package step5.domain;

import step5.domain.cargameStrategy.CarRacingGameStrategy;
import step5.domain.dto.ResultOfCar;
import step5.exception.RacingGameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameRound {

    private List<ResultOfCar> gameRoundResult;
    private List<String> winner;

    void play(List<Car> carList, CarRacingGameStrategy carRacingGameStrategy) {
        gameRoundResult = new ArrayList<>();

        for (Car car : carList) {
            int distance = carRacingGameStrategy.playGetDistanceToMove();
            car.move(distance);
            String name = car.getName();
            int position = car.getCurrentPosition();
            gameRoundResult.add(new ResultOfCar(name, position));

        }

        decideWinner();

    }

    private void decideWinner() {
        int max = gameRoundResult.stream()
                .mapToInt(ResultOfCar::getPosition)
                .max()
                .orElseThrow(() -> new RacingGameException("winner가 없습니다"));

        winner = gameRoundResult.stream()
                .filter(r -> (r.getPosition() == max))
                .map(ResultOfCar::getCarName)
                .collect(Collectors.toList());

    }

    public List<String> getWinners() {
        if (winner == null) {
            throw new RacingGameException("아직 게임을 진행하지 않았습니다");
        }
        return Collections.unmodifiableList(winner);

    }

    public List<ResultOfCar> getGameRoundResult() {
        if (gameRoundResult == null) {
            throw new RacingGameException("아직 게임을 진행하지 않았습니다.");
        }
        return Collections.unmodifiableList(gameRoundResult);
    }


}