package racingCar;

public class RacingCar {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        new Play(inputView.carCntScan(), inputView.roundScan());
    }
}
