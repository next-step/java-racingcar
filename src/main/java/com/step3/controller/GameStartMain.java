package com.step3.controller;

import com.step3.model.NumberSet;
import com.step3.view.InputView;

public class GameStartMain {
    public static void main(String[] args) {
        NumberSet inputNumbers = new InputView().input();
        new GameProcessor().getMovedCars(inputNumbers);
    }
}
