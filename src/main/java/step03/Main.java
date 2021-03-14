package step03;

public class Main {

    public static void main(String[] args){
        InputView inputView = new InputView();
        inputView.inputRacingData();

        RacingEventManager manager = new RacingEventManager(inputView.getCarCount(), inputView.getTryCount());
        manager.startRacing();

        ResultView resultView = new ResultView();
        resultView.showRacingResult(manager.getRacingResult());
    }
}