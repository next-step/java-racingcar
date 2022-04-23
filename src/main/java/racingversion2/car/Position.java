package racingversion2.car;

import java.util.Objects;

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

    public boolean isWinningPosition(int winningPosition) {
        return this.position >= winningPosition;
    }
}
