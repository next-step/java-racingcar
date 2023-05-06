package racingcar.domain.car;

public class Position {

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position){
        return new Position(position);
    }

    public void move(){
        this.position++;
    }

    public int getPosition(){
        return position;
    }
}
