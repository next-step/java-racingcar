package step3;

public class RacingUtils {

    public static void moveCarByRacingCondition(RacingCar racingCar, int carIndex, int roundIndex) {
        Car currentCar = racingCar.getCarByIndexNumber(carIndex);;
        currentCar.setPosition(RacingCondition.isMoveForward());
    }
    
    public static void goSingleRound(RacingCar car, int roundIndex) {
        for( int carIndex = 0 ; carIndex < car.getCarCount() ; carIndex++ ) {
            moveCarByRacingCondition(car, carIndex, roundIndex);
        }        
    }

    public static void goFullRace(RacingCar car) {
        for( int moveCount = 0 ; moveCount < car.getRoundCount() ; moveCount++ ) {
            goSingleRound(car, moveCount);
        }
    }

}
