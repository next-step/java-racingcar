package racing;

public class Position {

    private int position = 1;

    public int move(){
        position += 1;
        return position;
    }

    public int getPosition(){
        return position;
    }
}

