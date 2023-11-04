package step3;

public class RaceApp {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.readInput();
        ServiceLogic serviceLogic = new ServiceLogic();
        serviceLogic.process(inputView.getCarNumber(), inputView.getTryCount());
    }
}
