package racingcar.view;

import racingcar.gameinfo.CountInfo;
import utils.IntUtils;

import java.util.Scanner;

public class InputView {

    private InputView(){}
    
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntValue(String msg) {
        System.out.println(msg);
        String input = scanner.next();
        if(!IntUtils.isInt(input)) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
        return Integer.parseInt(input);
    }

    public static CountInfo getCountInfo() {
        int carCount = getIntValue("자동차 대수는 몇 대 인가요?");
        int tryCount = getIntValue("시도할 회수는 몇 회 인가요?");
        return new CountInfo(carCount, tryCount);
    }
}