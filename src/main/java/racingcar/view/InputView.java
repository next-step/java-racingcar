package racingcar.view;

import racingcar.gameinfo.CountInfo;

import java.util.Scanner;

public class InputView {

    private InputView(){}
    
    private static final Scanner scanner = new Scanner(System.in);

    private static int getIntValue(String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }

    public static CountInfo getCountInfo() {
        int carCount = InputView.getIntValue("자동차 대수는 몇 대 인가요?");
        int tryCount = InputView.getIntValue("시도할 회수는 몇 회 인가요?");
        if(carCount < 0 || tryCount < 0) throw new IllegalArgumentException("0보다 큰 값을 입력해주세요");
        return new CountInfo(carCount, tryCount);
    }

}