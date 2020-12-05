package com.nextstep.racinggame.view;

import com.nextstep.racinggame.domain.Name;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Name> getCarNames() {
        String userInput = SCANNER.nextLine();

        NamesInputView namesInputView = new NamesInputView(userInput);

        return namesInputView.parseToNames();
    }
}
