import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public void askNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요? : ");
    }

    public void askNumberOfTurns() {
        System.out.println("시도할 회수는 몇 회 인가요? : ");
    }

    public int getInputNumber() {
        return scanner.nextInt();
    }
}
