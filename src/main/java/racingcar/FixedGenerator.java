package racingcar;

public class FixedGenerator implements NumberGenerator{

    private final int fixedNum;

    public FixedGenerator(int num){
        this.fixedNum = num;
    }
    @Override
    public int makeValue() {
        return fixedNum;
    }
}
