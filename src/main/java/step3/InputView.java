package step3;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int inputTime = scanner.nextInt();

        if(carCount < 1 || inputTime < 1) {
            throw new IllegalArgumentException("입력값이 0보다 작을 수 없습니다.");
        }

        RacingGame racingGame = new RacingGame(carCount);
        for (int time = 0; time < inputTime; time++) {
            racingGame.playGame();
            System.out.println("");
        }


    }

}
