package step3;

public class Car {
    private int position = 0;

    public void canGo(){
        if(Dice.makeRandomNumber() > 4){
            this.position += 1;
        }
    }

    public int getPosition(){
        return this.position;
    }
}
