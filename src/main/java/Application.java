import calculator.CalculatorExcuter;
import java.util.Scanner;
import racingcar.controller.RacingGame;

public class Application {

    static final int CALCULATOR = 1;
    static final int RACE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 계산기를 사용하시려면 1, 자동차 경주를 사용하시려면 2를 눌러주세요.");
        int gameType = sc.nextInt();
        if (gameType == CALCULATOR) {
            CalculatorExcuter.execute();
        }
        if (gameType == RACE) {
            RacingGame.execute();
        }
    }
}
