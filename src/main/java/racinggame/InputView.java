package racinggame;

import java.util.Scanner;

public class InputView {

    public static InputDto read(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int repeat = scanner.nextInt();
        return new InputDto(carCount,repeat);
    }

}
