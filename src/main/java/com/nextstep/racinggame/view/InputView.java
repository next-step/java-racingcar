package com.nextstep.racinggame.view;

import com.nextstep.racinggame.domain.Name;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Name> getCarNames() {
        NamesInputView namesInputView = new NamesInputView(SCANNER.nextLine());

        return namesInputView.parseToNames();
    }

    public static int getRacingCount() {
        RacingCountInputView racingCountInputView = new RacingCountInputView(SCANNER.nextInt());

        return racingCountInputView.getRacingCount();
    }
}
