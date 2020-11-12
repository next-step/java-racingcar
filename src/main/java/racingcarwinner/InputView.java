package racingcarwinner;

import java.util.Scanner;

public class InputView {

    private InputView(){}

    public static void inputCarsName(){
        System.out.println("경주 할 자동차의 이름을 입력해주세요(이름은 쉽표(,)로 구분).");
        String carsName = new Scanner(System.in).nextLine();
        System.out.println(carsName);

        Cars.createCar(carsName);
    }

    public static void inputRoundCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        int roundCount = new Scanner(System.in).nextInt();
        System.out.println(roundCount);

        GameController.createGame(roundCount);
    }
}
