package step03;

public class Main {

    public static void main(String[] args){

        RacingEventManager manager = new RacingEventManager(InputView.inputRacingCarCount(), InputView.inputRacingTryCount());
        manager.startRacing();

        ResultView.showRacingResult(manager.getRacingResult());
    }
}