package step03;

public class Main {

    public static void main(String[] args){

        RacingEventManager manager = new RacingEventManager(InputView.inputRacingCarNames(), InputView.inputRacingTryCount());
        manager.startRandomRacing();

        ResultView.showRacingResult(manager.getRacingResult());
    }
}