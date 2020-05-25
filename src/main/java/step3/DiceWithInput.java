package step3;

import java.util.Random;

public class DiceWithInput implements Dice{

    private int number;

    public DiceWithInput(int input){
        this.number = input;
    }

    @Override
    public int makeNumber() {

        return this.number;
    }
}
