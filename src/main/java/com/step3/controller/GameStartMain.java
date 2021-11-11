package com.step3.controller;

import com.step3.model.InputNumber;
import com.step3.view.InputView;

public class GameStartMain {
    public static void main(String[] args) {
        InputNumber inputNumbers = new InputView().input();
        new GameProcessor().startGame(inputNumbers);
    }
}
