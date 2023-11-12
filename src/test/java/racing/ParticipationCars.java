package racing;

import java.util.List;

public class ParticipationCars {

    private final List<Car> participationCars;

    private ParticipationCars(List<Car> participationCars) {
        this.participationCars = participationCars;
    }

    public static ParticipationCars defaultOf(List<Car> carList) {
        return new ParticipationCars(carList);
    }

    public Winners voteWinner(AdvanceprobabilitySixtyPercentReferee referee) {
        return referee.voteWinner(this.participationCars);

    }
}
