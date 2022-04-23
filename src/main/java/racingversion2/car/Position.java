package racingversion2.car;

public class Position {

    private int position;

    public Position(){}

    public Position(int position) {
        this.position = position;
    }

    public void increase(){
        this.position ++;
    }

    public int getPosition(){
        return this.position;
    }

}
