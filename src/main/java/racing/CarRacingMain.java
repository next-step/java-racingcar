package racing;

import java.util.Scanner;

public class CarRacingMain {

    private static final String FIRST_REQUEST = "자동차 대수는 몇 대 인가요?";
    private static final String SECOND_REQUEST = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        Racing racing = new Racing();
        Scanner scanner = new Scanner(System.in);
        System.out.println(FIRST_REQUEST);
        racing.createCarByRacing(scanner.next());
        System.out.println(SECOND_REQUEST);
        String secondInValue = scanner.next();

        scanner.close();
    }



}
