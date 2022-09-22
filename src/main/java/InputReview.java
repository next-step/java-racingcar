import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReview {

    private int cars;
    private int attempts;

    public void inputCarNumber() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        this.cars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.attempts = scanner.nextInt();
    }

    public int getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }
}
