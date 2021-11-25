package step5.domain;

import step5.domain.cargameStrategy.CarRacingGameStrategy;
import step5.domain.dto.CarData;
import step5.exception.RacingGameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRound {

    private final List<CarData> roundResult;

    public GameRound() {
        roundResult = new ArrayList<>();
    }

    void play(Cars cars, CarRacingGameStrategy carRacingGameStrategy) {
        List<Car> carList = cars.getCarList();
        for (Car car : carList) {
            int distance = carRacingGameStrategy.playGetDistanceToMove();
            car.move(distance);
            String name = car.getName();
            int position = car.getCurrentPosition();
            roundResult.add(new CarData(name, position));
        }
    }

    public List<String> winners(){
        return Winners.decideWinner(roundResult);
    }

    public List<CarData> getRoundResult() {
        if (roundResult.isEmpty()) {
            throw new RacingGameException("아직 게임을 진행하지 않았습니다.");
        }
        return Collections.unmodifiableList(roundResult);
    }

}