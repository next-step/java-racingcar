package racingcar;

import racingcar.model.InputModel;

import java.util.Scanner;

public class InputView {

    public InputModel getInput() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();

        return new InputModel(carNum, times);
    }

}

