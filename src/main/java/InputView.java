import java.util.Scanner;

public class InputView {
    void userInput(RacingGame racingGame){
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        racingGame.setNumberOfCar(scanner.nextInt());

        System.out.println("시도할 회수는 몇 회 인가요?");
        racingGame.setTime(scanner.nextInt());
    }
}
