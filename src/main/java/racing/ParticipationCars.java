package racing;

import racing.inout.OutPutView;

import java.util.ArrayList;
import java.util.List;

public class ParticipationCars {

    private final List<Car> participationCars;

    private ParticipationCars(List<Car> participationCars) {
        this.participationCars = participationCars;
    }

    public static ParticipationCars defaultOf(List<Car> carList) {
        return new ParticipationCars(carList);
    }

    public Winners voteWinner() {
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
    private void addSameDistanceCar(Car winner, Car each, List<Car> winners) {
        if (each.equalsDistance(winner)) {
            winners.add(each);
        }
    }

    public void move(Referee referee) {
        for (Car each : participationCars) {
            boolean canMove = referee.judgeToMove();
            each.move(canMove);
        }
    }

    public void printStatus(OutPutView outPutView) {
        for (Car each : participationCars) {
            each.printStatus(outPutView);
        }
        outPutView.printGongBack();
    }
}
