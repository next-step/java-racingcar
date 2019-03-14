package racing;

public class Car {

    private static final int CRITERION_TO_MOVE = 4;
    private int position = 0;

    public Car(int position){
        this.position = position;
    }

    public void move(int randomValue) {
        if (randomValue > CRITERION_TO_MOVE) {
            this.position++;
        }
    }

    public int getPosition() { return position; }

    @Override
    public String toString() {
        StringBuffer tmp = new StringBuffer();
        for(int i = 0 ; i < position ; i++) {
            tmp.append("-");
        }
        return tmp.toString();
    }

}
