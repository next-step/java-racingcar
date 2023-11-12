package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdvanceprobabilitySixtyPercentReferee implements Referee {

    @Override
    public boolean judgeToMove() {
        Random random = new Random();
        random.nextInt(10);
        return random.nextInt(10) > STANDARD_NUMBER_TO_JUDGE_TO_MOVE;
    }

    @Override
    public Winners voteWinner(List<Car> participationCars) {
        Car winner = this.findWinner(participationCars);
        return this.findSameWinner(participationCars,winner);
    }

    private Winners findSameWinner(List<Car> participationCars, Car winner) {
        List<Car> winners = new ArrayList<>();
        for (Car each : participationCars) {
            this.addSameDistanceCar(winner, each, winners);
        }
        return Winners.defaultOf(winners);
    }

    private void addSameDistanceCar(Car winner, Car each, List<Car> winners) {
        if (each.equalsDistance(winner)) {
            winners.add(each);
        }
    }

    private Car findWinner(List<Car> participationCars) {
        int size = participationCars.size();
        Car winner = null;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 1; j < size; j++) {
                winner = participationCars.get(i).winnerIs(participationCars.get(j));
            }
        }
        return winner;
    }


}
