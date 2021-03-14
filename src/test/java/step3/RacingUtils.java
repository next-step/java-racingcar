package step3;

public class RacingUtils {

    private static final String CAR_MOVEMENT = "-";        //차량의 이동표기
    
    public static String moveForward(RacingCar car, int carIndex, int roundIndex) {

        if( RacingCondition.isFirstRound(roundIndex) ) {
            car.setCurrentPosition(carIndex, roundIndex, CAR_MOVEMENT);
            return CAR_MOVEMENT;
        }

        String currentPosition = car.getCurrentPosition(carIndex, roundIndex - 1);
        
        if( RacingCondition.isMoveForward() ) {
            currentPosition += CAR_MOVEMENT;
        }

        car.setCurrentPosition(carIndex, roundIndex, currentPosition);
        return currentPosition;
    }
    
    public static void goSingleRound(RacingCar car, int roundIndex) {
        for( int carIndex = 0 ; carIndex < car.getCarCount() ; carIndex++ ) {
            moveForward(car, carIndex, roundIndex);
        }        
    }

    public static void goFullRace(RacingCar car) {
        for( int moveCount = 0 ; moveCount < car.getRoundCount() ; moveCount++ ) {
            goSingleRound(car, moveCount);
        }
    }

}
