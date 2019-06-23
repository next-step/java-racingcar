package racingcar;

import racingcar.utils.NumGenerator;

public class FixedNumGenerator implements NumGenerator{
    private int bound;

    public FixedNumGenerator(int bound){
        this.bound = bound;
    }
    @Override
    public int nextInt(){
        return this.bound;
    }
}
