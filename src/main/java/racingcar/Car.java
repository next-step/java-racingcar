package racingcar;

public class Car {
    private int position = 0;

    public void move(int number){
        if (number >= 4){
            this.position +=1;
        }
    }
    public int getPosition(){
        return this.position;
    }
}
