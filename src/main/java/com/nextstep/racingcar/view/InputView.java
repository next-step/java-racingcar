package com.nextstep.racingcar.view;

import com.nextstep.racingcar.util.DriverNameParser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private List<String> driverNames;
    private int roundNumber;

    public InputView(List<String> driverNames, int roundNumber) {
        this.driverNames = driverNames;
        this.roundNumber = roundNumber;
    }

    public static InputView create(Scanner scanner) {
        System.out.println("참여 할 운전자들의 이름을 입력해주세요(공백 없이 쉼표로 구분)");
        String driverNameString = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요");
        int roundNumber = scanner.nextInt();

        return new InputView(DriverNameParser.toUserNameList(driverNameString), roundNumber);
    }

    public List<String> getDriverNames() {
        return this.driverNames;
    }

    public int getRoundNumber() {
        return this.roundNumber;
    }
}
