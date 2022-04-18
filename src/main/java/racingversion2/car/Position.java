package racingversion2.car;

public class Position {

    private final static int DEFAULT_POSITION = 0;

    private int position;

    public Position(){
        this.position = DEFAULT_POSITION;
    }

    public void increase(){
        this.position ++;
    }

    public int getPosition(){
        return this.position;
    }

}
