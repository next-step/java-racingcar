import java.util.Scanner;

public class RacingGame {

    private Scanner scanner;

    RacingGame () {
        scanner = new Scanner(System.in);
    }

    public void end() {
        if (scanner != null) scanner.close();
    }

    private int inputIntArgument(String description){
        System.out.println(description);
        return scanner.nextInt();
    }

    public void start() {
        try {
            int numberOfCars = inputIntArgument("자동차 대수는 몇 대 인가요?");
            int numberOfAttempts = inputIntArgument("시도할 회수는 몇 회 인가요?");
        } catch (Exception exception) {
            exception.printStackTrace();
            end();
        }
    }

}
