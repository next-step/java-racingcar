package step4.domain;

import step4.domain.cargameStrategy.CarRacingGameStrategy;
import step4.exception.RacingGameException;

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
                .mapToInt(r -> r.position)
                .max()
                .orElseThrow(() -> new RacingGameException("winner가 없습니다"));

        winner = gameRoundResult.stream()
                .filter(r -> (r.position == max))
                .map(r -> r.carName)
                .collect(Collectors.toList());

    }

    public List<String> getWinners() {
        if (winner == null) {
            throw new RacingGameException("아직 게임을 진행하지 않았습니다");
        }
        return Collections.unmodifiableList(winner);

    }

    public List<ResultOfCar> getGameRoundResult() {
        if(gameRoundResult==null){
            throw new RacingGameException("아직 게임을 진행하지 않았습니다.");
        }
        return Collections.unmodifiableList(gameRoundResult);
    }

    public static class ResultOfCar {
        private String carName;
        private int position;

        public ResultOfCar(String carName, int position) {
            this.carName = carName;
            this.position = position;
        }

        public String getCarName() {
            return carName;
        }

        public int getPositoin() {
            return position;
        }
    }
}