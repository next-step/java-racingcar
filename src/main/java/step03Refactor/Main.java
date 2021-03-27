package step03Refactor;

public class Main {

    public static void main(String[] args){
        RacingManager racingManager = new RacingManager(InputView.inputRacingCarNames(), InputView.inputRacingTryCount());
        racingManager.startRandomRacing();
    }
}
