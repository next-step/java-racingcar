package racing;

public class Car {


    private int position;


    public void move() {
        this.position += 1;
    }


    public void move(int randomNumber) {
        if (randomNumber > 4) move();
    }


    public int getPosition() {
        return this.position;
    }


}
