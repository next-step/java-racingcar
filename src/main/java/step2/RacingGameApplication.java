package step2;

public class RacingGameApplication {

    private static  InputView input = new InputView();

    public static void main(String[] args){
        int carQty = input.setCarNumber();
        int tryCount = input.setTryCount();

        RacingGame rg = new RacingGame();
        ValidationCheck vc = new ValidationCheck();

        vc.checkInputZero(carQty, tryCount);
        rg.setInitPosition(carQty);

        System.out.println("실행결과");
        while (tryCount-- > 0){
            rg.startRacing(carQty);
            rg.resultView();
        }
    }

}
