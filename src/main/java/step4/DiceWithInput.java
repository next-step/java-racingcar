package step4;

public class DiceWithInput implements Dice {

    private int number;

    public DiceWithInput(int input){
        this.number = input;
    }

    @Override
    public int makeNumber() {

        return this.number;
    }
}
