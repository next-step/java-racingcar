package racingcar.view;

import racingcar.util.StringUtil;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private List<String> carNames;
    private int rounds;

    public List<String> getCarNames() {
        return carNames;
    }
    public int getRounds() {
        return rounds;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분)");
        carNames = StringUtil.splitString(scanner.next());

        System.out.println("몇 번 시도하나요?");
        rounds = validateRounds(scanner.nextInt());
    }

    private int validateRounds(int rounds) {
        if (rounds <= 0)
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다 :) ");
        return rounds;
    }
}
