package step5.domain;

import step5.domain.cargameStrategy.CarRacingGameStrategy;
import step5.domain.dto.ResultOfCar;
import step5.exception.RacingGameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRound {

    private List<ResultOfCar> gameRoundResult;

    void play(List<Car> carList, CarRacingGameStrategy carRacingGameStrategy) {
        gameRoundResult = new ArrayList<>();

        for (Car car : carList) {
            int distance = carRacingGameStrategy.playGetDistanceToMove();
            car.move(distance);
            String name = car.getName();
            int position = car.getCurrentPosition();
            gameRoundResult.add(new ResultOfCar(name, position));

        }

    }



    public List<ResultOfCar> getGameRoundResult() {
        if (gameRoundResult == null) {
            throw new RacingGameException("아직 게임을 진행하지 않았습니다.");
        }
        return Collections.unmodifiableList(gameRoundResult);
    }

}