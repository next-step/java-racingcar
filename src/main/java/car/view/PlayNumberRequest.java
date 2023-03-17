package car.view;

import java.util.Scanner;

public class PlayNumberRequest {

    private final int number;

    public PlayNumberRequest(int number) {
        this.number = number;
    }

    public static PlayNumberRequest playNumberRequest() {
        int number = numberRequest();
        return new PlayNumberRequest(number);
    }

    private static int numberRequest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회인가요?");
        return sc.nextInt();
    }

    public int getNumber() {
        return number;
    }
}
