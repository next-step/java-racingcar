package step3;

public class Application {
    
    public static void main(String[] args) {
        Cars cars;
        RacingCar racing;
        
        RacingView view = new RacingView();

        String[] carNames = view.inputCarNamesView();
        int roundInput = view.inputRacingRoundView();
        
        try {
            
            cars = new Cars(carNames);
            racing = new RacingCar(cars);
            
            view.printBeforRace();
            
            for( int rIndex = 0 ; rIndex < roundInput ; rIndex++ ) {
                racing.raceSingleRound(racing.getRacingCarMoveConditions());
                view.printCurrentRound(racing);
            }
            
            view.printWinner(racing);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
