package com.racing.game.view;

import com.racing.game.utils.InputUtils;
import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.entity.RaceEntry;
import java.util.Scanner;

public class InputView {

    private final String USER_INPUT_MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String USER_INPUT_MESSAGE_LAPS = "시도할 회수는 몇회인가요?";

    private final InputViewModel inputViewModel;

    public InputView(InputViewModel inputViewModel) {
        this.inputViewModel = inputViewModel;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void drawCarCountInputView() {
        System.out.println(USER_INPUT_MESSAGE_CAR_NAMES);
        inputViewModel.saveCar(
                RaceEntry.from(InputUtils.toCarList(scanner.nextLine())));
    }

    public void drawTryCountInputView() {
        System.out.println(USER_INPUT_MESSAGE_LAPS);
        inputViewModel.saveLaps(scanner.nextInt());
    }
}
