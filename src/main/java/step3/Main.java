package step3;

public class Main {

    public static void main(String[] args){
        InputView inputView = new InputView();
        RacingEvent racingEvent = new RacingEvent(inputView.getCarCount(), inputView.getTryCount());
        racingEvent.startEvent();
    }
}
