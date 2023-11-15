package step3;

import java.util.Scanner;

public class InPutView {
    public final int howManyCars;
    public final int howManyTimesToTry;

    public InPutView(int howManyCars, int howManyTimesToTry) {
        this.howManyCars = howManyCars;
        this.howManyTimesToTry = howManyTimesToTry;
    }

    public static InPutView getInPutView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int howManyCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int howManyTimesToTry = scanner.nextInt();

        return new InPutView(howManyCars, howManyTimesToTry);
    }
}
