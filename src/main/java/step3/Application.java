package step3;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        
        List<Car> cars = new ArrayList<Car>();
        RacingCar racing;
        
        RacingView view = new RacingView();
        String[] carNames = view.inputCarCountView();
        int roundInput = view.inputRacingRoundView();
        
        try {
            
            for(String carName : carNames) {
                cars.add(new Car(carName));
            }
            
            racing = new RacingCar(cars, roundInput);
            
            System.out.println("\n실행 결과 : ");
            
            for( int rIndex = 0 ; rIndex < racing.getTotalRound() ; rIndex++ ) {
                racing.raceSingleRound();
                view.printCurrentRound(racing);
            }
            
            view.printWinner(racing);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
