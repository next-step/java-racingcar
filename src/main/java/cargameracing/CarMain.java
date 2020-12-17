package cargameracing;

import java.util.List;
import java.util.Scanner;

/**
 * Controller Role
 * @author minji
 */
public class CarMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int playCount = scanner.nextInt();

        // CarRacingGameInputView : 입력 View 객체
        CarRacingGameInputView input = new CarRacingGameInputView(names, playCount);
        List<String> carName = input.getCarName();

        // CarRacingGame : 도메인 객체 (자동차 경주 게임에 대한 역할 담당)
        CarRacingGame carRacingGame = new CarRacingGame(carName, playCount);

        System.out.println("실행 결과");
       while(carRacingGame.getTryNo().racing()) {
            carRacingGame.playGame(new RandomMovingStrategy());
            // CarRacingGameOutputView : 출력 View 객체
            CarRacingGameOutputView.displayResult(carRacingGame.getCars());
            System.out.println();
        }
        carRacingGame.displayFinalWinners();
    }
}
