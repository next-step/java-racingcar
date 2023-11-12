package racing;

import racing.inout.OutPutView;

import java.util.List;

public class ParticipationCars {

    private final List<Car> participationCars;

    private ParticipationCars(List<Car> participationCars) {
        this.participationCars = participationCars;
    }

    public static ParticipationCars defaultOf(List<Car> carList) {
        return new ParticipationCars(carList);
    }

    public Winners voteWinner(Referee referee) {
        return referee.voteWinner(this.participationCars);

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
