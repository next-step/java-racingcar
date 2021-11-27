package racingcar.view;

import racingcar.vo.CarsDto;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private String carNames;
    private String[] names;
    private int rounds;

    public InputView() {
        scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.next();
        names = carNames.split(",");

        System.out.println("시도할 회수는 몇 회 인가요?");
        rounds = scanner.nextInt();
    }

    public CarsDto initCars() {
        return new CarsDto(names);
    }

    public int getRounds() {
        return this.rounds;
    }
}
