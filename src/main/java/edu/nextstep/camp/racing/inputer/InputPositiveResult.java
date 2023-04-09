package edu.nextstep.camp.racing.inputer;

public class InputPositiveResult {

    private final int positiveNumber;

    public InputPositiveResult(String input) {
        this.positiveNumber = toPositive(input);
    }

    private int toPositive(String numStr){
        int positiveNumer = Integer.parseInt(numStr);

        if (positiveNumer < 0){
            throw new IllegalArgumentException("Please input a positive number.");
        }

        return positiveNumer;
    }

    public int result(){
        return positiveNumber;
    }
}

