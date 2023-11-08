package com.racing.game.view;

import com.racing.game.viewmodel.InputViewModel;
import com.racing.game.vo.CarCount;
import com.racing.game.vo.TryCount;
import java.util.Scanner;

public class InputView {

    private final InputViewModel inputViewModel;

    public InputView(InputViewModel inputViewModel) {
        this.inputViewModel = inputViewModel;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void drawCarCountInputView() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        inputViewModel.saveCarCount(CarCount.of(scanner.nextInt()));
    }

    public void drawTryCountInputView() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        inputViewModel.saveTryCount(TryCount.of(scanner.nextInt()));
    }
}
