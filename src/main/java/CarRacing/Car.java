package CarRacing;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private int position = 0;

    public boolean isMovable(int randomNum){
        return randomNum >= MOVE_THRESHOLD;
    }

    public void updatePosition(int randomNum){
        if(isMovable(randomNum))
            position++;
    }

    public int getPosition(){
        return this.position;
    }

}
