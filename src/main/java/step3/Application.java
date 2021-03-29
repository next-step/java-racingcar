package step3;

public class Application {
    public static void main(String[] args) {
        int carInput = 0;
        int roundInput = 0;
        
        RacingView view = new RacingView();
        carInput   = view.inputCarCountView();
        roundInput = view.inputRacingRoundView();
        
        System.out.println("\n실행결과");

        RacingCar racing = new RacingCar(carInput, roundInput);
        
        for( int rIndex = 0 ; rIndex < racing.getTotalRound() ; rIndex++ ) {
            racing.raceSingleRound();
            view.printCurrentRound(racing);
        }
    }
}
