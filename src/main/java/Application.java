import calculatorFunction.Calculator;
import java.util.Scanner;
import racingcar.Race;

public class Application {

    private static final int CALCULATOR = 1;
    private static final int RACE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 계산기를 사용하시려면 1, 자동차 경주를 사용하시려면 2를 눌러주세요.");
        int gameName = sc.nextInt();
        if (gameName == CALCULATOR) {
            Calculator.execute();
        }
        if (gameName == RACE) {
            Race race = new Race();
            race.execute();
        }
    }
}
