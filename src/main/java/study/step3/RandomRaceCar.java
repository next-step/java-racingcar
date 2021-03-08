package study.step3;

public class RandomRaceCar implements Car{
    private static final int START_POSITION = 1;
    private int position;
    public RandomRaceCar(){
        this.position = START_POSITION;
    }
    @Override
    public int move(){
        if(NumberChecker.checkCondition()){
            position = position + 1;
        }
        return position;
    }
}
