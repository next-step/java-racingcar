package step2;

public class RacingGameApplication {

    private static  InputView input = new InputView();

    public static void main(String[] args){
        int carQty = input.setCarNumber();
        int tryCount = input.setTryCount();

        RacingGame rg = new RacingGame();
        rg.setInitPosition(carQty);

        while (tryCount-- > 0){
            rg.startRacing(carQty);
            rg.resultView();
        }
    }
}
