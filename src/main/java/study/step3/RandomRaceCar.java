package study.step3;

public class RandomRaceCar implements Car{
    private int position;
    public RandomRaceCar(){
        this.position = 1;
    }
    @Override
    public int move(){
        if(NumberChecker.checkCondition()){
            position = position + 1;
        }
        return position;
    }
}
