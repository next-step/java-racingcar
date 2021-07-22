package racingcar;

import java.util.Scanner;

/*
 * 자동차 경주 Input
 */
public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public String[] insertCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요");
        String text = sc.nextLine();
        if(!text.contains(",")){
            throw new IllegalArgumentException("자동차 이름은 ','로 구분되어야 합니다.");
        }
        return getNameOfCars(text);
    }

    private String[] getNameOfCars(String text) {
        return text.split(",");
    }

    public int getNumberOfTry() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return sc.nextInt();
    }
}
