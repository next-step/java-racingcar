package car_racing;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MESSAGE_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요 ?";
    private static final String INPUT_MESSAGE_NUMBER_OF_ROUND = "시도할 회수는 몇 회 인가요 ?";
    private static final String INPUT_MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";

    public int showMessageAndGetNumberOfCars() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MESSAGE_NUMBER_OF_CARS);

        return scanner.nextInt();
    }

    public int showMessageAndGetNumberOfRound() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MESSAGE_NUMBER_OF_ROUND);

        return scanner.nextInt();
    }

    public String showMessageAndGetCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_MESSAGE_CAR_NAMES);
        return scanner.nextLine();
    }
}
