package study1.step4;

public class Car {
    public final String racer;
    public int distance;

    public Car(String racer, int initialNumber){
        this.racer = racerValidate(racer);
        this.distance = initialNumber;
    }

    public void move(Decision generator){
        if(generator.moveDecision()){
            this.distance ++;
        }
    }

    public String getMoveResult(){
        StringBuilder raceDistance = new StringBuilder();
        for(int i = 0; i < this.distance; i++){
            raceDistance.append("-");
        }
        return this.racer + ": " + raceDistance.toString();
    }

    private String racerValidate(String racerName){
        if(Validator.inputValidate(racerName)){
            throw new IllegalArgumentException("자동차 이름이 올바르지 않습니다.");
        }
        return racerName;
    }
}
