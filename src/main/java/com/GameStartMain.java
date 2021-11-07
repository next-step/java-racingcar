package com;

import com.view.InputView;

public class GameStartMain {
    public static void main(String[] args) {
        NumberSet inputNumbers = new InputView().input();
        new GameProcessor().start(inputNumbers);
    }
}
