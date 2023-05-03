import java.util.Scanner;

public class InputView {

    private int totalOfCars;
    private int round;


    public void startToGameSetting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        totalOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        round = scanner.nextInt();
    }

    public int getTotalOfCars() {
        return totalOfCars;
    }

    public int getRound() {
        return round;
    }
}
