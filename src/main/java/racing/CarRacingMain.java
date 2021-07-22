package racing;

import java.util.Scanner;

public class CarRacingMain {

    private static final String FIRST_REQUEST = "자동차 대수는 몇 대 인가요?";
    private static final String SECOND_REQUEST = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        MessageBox messageBox = new MessageBox();
        Racing racing = new Racing(messageBox);
        Scanner scanner = new Scanner(System.in);

        messageBox.commonMessageBox(FIRST_REQUEST);
        racing.createCarByRacing(scanner.next());

        messageBox.commonMessageBox(SECOND_REQUEST);
        racing.tryRacingByCar(scanner.next());

        scanner.close();
    }



}
