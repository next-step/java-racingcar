package racingcarwinner;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public String[] getCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = scanner.nextLine();
        return getCarNames(carName);
    }

    public int getPlayCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public String[] getCarNames(String carName) {
        String[] carNames = carName.trim().split(",");
        for (String name : carNames) {
            checkCarNameLength(name);
        }
        return carNames;
    }

    //자동차 이름 5자 초과하는지 input 데이터 검증
    public void checkCarNameLength(String name) {
        if (name.length() > 5) {
            System.out.println("자동차 이름은 5글자를 초과할 수 없습니다.");
            throw new IllegalStateException("자동차 이름 5글자 초과 오류");
        }
    }
}
