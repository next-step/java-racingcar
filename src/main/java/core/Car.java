package core;


public class Car implements CarAction{
    static final int GOING_NUM = 4;
    public int position;

    public Car(int position) {
        this.position = position;
    }

    public void carAction(int randNum) {
        move(isMove(randNum));
    }

    public void move(boolean isMove) {
        if(isMove) {
            this.position++;
        }
    }

    @Override
    public boolean isMove(int randNum) {
        if(randNum >= GOING_NUM) {
            return true;
        }
        return false;
    }

}
