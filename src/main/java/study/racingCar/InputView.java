package study.racingCar;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    static String inputCars(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        String carNum =  scanner.nextLine();
        return carNum;
    }

    static String inputRounds(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        String rounds = scanner.nextLine();
        return rounds;
    }
}
