import java.util.Scanner;

public class InputView {
    private static Scanner SC = new Scanner(System.in);

    public static int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int num = Integer.parseInt(SC.nextLine());
        if (num < 0) {
            throw new IllegalArgumentException("0이상 입력 해주세요");
        }
        return num;
    }

    public static int getNumberOfGames() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int num = Integer.parseInt(SC.nextLine());
        if (num < 0) {
            throw new IllegalArgumentException("0이상 입력 해주세요");
        }
        return num;
    }
}
