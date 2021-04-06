package RacingGame.view;

import RacingGame.RacingGame;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    public int inputNumOfCar(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextInt();
    }

    public String[] inputNameOfCars(){
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉽표(,)를 기준으로 구분)");
        String inputNames = SCANNER.nextLine();
        return inputNames.split(",");
    }

    public int inputNumOfTry(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }

}
