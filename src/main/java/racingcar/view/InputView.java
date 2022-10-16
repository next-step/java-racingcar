package racingcar.view;

import racingcar.race.RacingModel;

import java.util.Scanner;

public class InputView {
    private String[] names;
    private int tryCount;
    public void printStartScreen(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String inputName = scanner.next();
        this.names = inputName.split(",");

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.tryCount = scanner.nextInt();
    }

    public RacingModel getUserInputData() {
        return new RacingModel(names, tryCount);
    }

}

