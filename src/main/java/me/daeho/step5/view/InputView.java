package me.daeho.step5.view;

import me.daeho.utils.StringUtils;

import java.util.Scanner;

public class InputView {
    private final static String CAR_NAME_DELIMITER = ",";

    private String[] carNames;
    private int time;

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public InputView inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputName = new Scanner(System.in).nextLine();

        if(StringUtils.isEmpty(inputName))
            throw new IllegalArgumentException();

        this.carNames = inputName.split(CAR_NAME_DELIMITER);

        return this;
    }

    public InputView inputTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.time = new Scanner(System.in).nextInt();

        return this;
    }


    public String[] getCarNames() {
        return carNames;
    }

    public int getTime() {
        return time;
    }
}
