package racingcar.view;

import racingcar.service.RacingGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> getRacingCarNames() {
        System.out.println("******** 자동차 레이싱 게임 ********");
        System.out.println("경기에 참가하는 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)");
        String racingCarNames = scanner.nextLine();
        List<String> carNameList = Arrays.asList(racingCarNames.split(","));

        boolean isCorrectCarName = RacingGame.validateCarName(carNameList);
        if(!isCorrectCarName) {
            throw new IllegalArgumentException("자동차 이름은 숫자와 문자 조합이고 5자를 초과할 수 없습니다.");
        }

        return carNameList;
    }

    public int getRacingRound() {
        System.out.println("경기는 몇 ROUND 까지 진행하나요?");
        return scanner.nextInt();
    }

}
