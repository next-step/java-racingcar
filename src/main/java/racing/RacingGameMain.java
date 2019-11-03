package racing;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingInputCarCountView racingInputCarCountView = new RacingInputCarCountView();
        RacingInputTimeView racingInputTimeView = new RacingInputTimeView();

        RacingStadium racingStadium = new RacingStadium(racingInputCarCountView.carCount, racingInputTimeView.time);
        racingStadium.open();
    }

}
