package step3;

import java.util.Scanner;

public class RacingView {

    private static final String CAR_MOVEMENT = "-";        //차량의 이동표기
    
    Scanner scanner;
    
    public RacingView() {
        scanner = new Scanner(System.in);
    }
    
    public int inputCarCountView() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }
    
    public int inputRacingRoundView() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
    
    public void printCurrentRound(RacingCar racingInfo) {
        Car currentCar;
        for( int cIndex = 0 ; cIndex < racingInfo.getTotalCarCount() ; cIndex++ ) {
            currentCar = racingInfo.getCarByIndex(cIndex);
            System.out.println(CAR_MOVEMENT.repeat(currentCar.getPosition()));
        }
        System.out.println();
    }
}
