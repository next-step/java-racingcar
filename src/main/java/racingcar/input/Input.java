package racingcar.input;

import racingcar.input.request.CarRequest;

import java.util.Scanner;

public class Input {

    private final Scanner scanner = new Scanner(System.in);
    public CarRequest inputCar(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return new CarRequest(scanner.nextLine());
    }

    public int inputRaceCount(){
        System.out.println("시도할 횟수는 몇 회 인가요??");
        return Integer.valueOf(scanner.nextLine());
    }
}
