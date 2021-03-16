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
    
    public void printCarPosition(Car car, int round) {
        for( int index = 0 ; index < car.getPosition(round) ; index++ ) {
            System.out.print(CAR_MOVEMENT);
        }
        System.out.println();
    }

    public void resultView(RacingCar racingInfo) {

        System.out.println("\n실행 결과");
        
        if( racingInfo == null ) {
            return ;
        }
        
        for( int moveCount = 0 ; moveCount < racingInfo.getRoundCount() ; moveCount++ ) {
            for( int carIndex = 0 ; carIndex < racingInfo.getCarCount() ; carIndex++ ) {
                printCarPosition(racingInfo.getCarByIndexNumber(carIndex), moveCount);
            }
            System.out.println();
        }
    }
}
