import java.util.Scanner;

public class InputView {
    private static Scanner SC = new Scanner(System.in);

    public static int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int num = Integer.parseInt(SC.nextLine());
        return num;
    }
}
