package ch01.racinggame.view;

import ch01.racinggame.Domain.InputData;

import java.util.Scanner;

public class InputView {

    public InputData getInputData() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        Scanner sc = new Scanner(System.in);
        String inputNameOfCars = sc.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = sc.nextInt();
        return new InputData(inputNameOfCars,attemptCount);
    }

}
