package step3;

import java.util.List;
import java.util.Scanner;

public class RacingView {

    private static final String CAR_MOVEMENT = "-";
    private static final String DELIMITER = ",";
    
    Scanner scanner;
    
    public RacingView() {
        scanner = new Scanner(System.in);
    }
    
    public String[] inputCarCountView() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.next();
        
        return carNames.split(DELIMITER);
    }
    
    public int inputRacingRoundView() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
    
    public void printCurrentRound(RacingCar racingInfo) {
        Car currentCar;
        for( int cIndex = 0 ; cIndex < racingInfo.getTotalCarCount() ; cIndex++ ) {
            currentCar = racingInfo.getCarByIndex(cIndex);
            System.out.println(currentCar.getName() + " : " + CAR_MOVEMENT.repeat(currentCar.getPosition()));
        }
        System.out.println();
    }
    
    public void printWinner(RacingCar racingInfo) {
        StringBuilder builder = new StringBuilder();
        
        List<Car> winners = racingInfo.getWinner();
        for( int cIndex = 0 ; cIndex < winners.size() ; cIndex++ ) {
            builder.append(winners.get(cIndex).getName());
            builder.append(cIndex + 1 < winners.size() ? ", " : ""); 
        }
        
        System.out.println(builder.toString() + "가 최종 우승했습니다.");
    }
}
