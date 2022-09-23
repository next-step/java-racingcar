package service.impl;

import service.GameStrategy;
import service.NumberPicker;

public class RandomStrategy implements GameStrategy {

    public static final int MIN_MOVE_NUMBER = 4;

    private final NumberPicker numberPicker;

    public RandomStrategy(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    @Override
    public boolean isCarMove() {
        return this.numberPicker.pick() >= MIN_MOVE_NUMBER;
    }
}