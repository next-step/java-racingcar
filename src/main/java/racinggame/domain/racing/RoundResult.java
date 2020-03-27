package racinggame.domain.racing;

public class RoundResult {
    private RacingCars result;

    public RoundResult(RacingCars racingCars) {
        this.result = new RacingCars(racingCars);
    }

    public RacingCars getResult() {
        return result;
    }
}
