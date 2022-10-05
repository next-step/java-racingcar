package step3.view;

import step3.domain.Sepatation;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Sepatation SEPATATION = new Sepatation();
    private static final String CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COUNT = "시도할 회수는 몇 회 인가요?";

    public String[] input() {
        System.out.println(CARS_NAME);
        return SEPATATION.nameSeparation(SCANNER.nextLine());
    }

    public int count() {
        System.out.println(COUNT);
        return SCANNER.nextInt();
    }
}
