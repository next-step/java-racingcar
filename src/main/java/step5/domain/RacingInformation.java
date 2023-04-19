package step5.domain;

public class RacingInformation {

    private final RacingCarGroup racingCarGroup;
    private final Reps reps;

    private RacingInformation(RacingCarGroup racingCarGroup, Reps reps) {
        this.racingCarGroup = racingCarGroup;
        this.reps = reps;
    }

    public static RacingInformation of(String inputCarName, int reps) {
        return new RacingInformation(RacingCarGroup.of(inputCarName), new Reps(reps));
    }

    public boolean isContinue() {
        return reps.isOverZero();
    }

    public Reps getReps() {
        return reps;
    }

    public RacingCarGroup getRacingCarGroup() {
        return racingCarGroup;
    }
}
