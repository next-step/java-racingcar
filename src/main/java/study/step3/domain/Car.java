package study.step3.domain;

public class Car {



    public int getPosition() {
        return position;
    }

    private int position = 1;

    public void move(){
        this.position += 1;
    }

}
