package com.racingcar.view;

import com.racingcar.view.model.GameInput;

import java.util.Scanner;

public class DefaultInputView extends InputView {
    @Override
    public GameInput drawAndParse() {
        GameInput input = new GameInput();
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        input.setCarInput(scanner.nextLine());

        System.out.println("시도할 횟수는 몇 회 인가요?");
        input.setGameRound(scanner.nextInt());

        System.out.println();

        return input;
    }

}
