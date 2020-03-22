import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameRole getGameRole() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberOfAttempts = scanner.nextInt();

        return new GameRole(numberOfCars, numberOfAttempts);
    }


}
