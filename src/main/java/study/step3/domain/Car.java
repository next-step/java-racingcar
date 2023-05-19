package study.step3.domain;

public class Car {

    private static final char POSITION_MARK = '*';

    public int getPosition() {
        return position;
    }

    public String getPositionStr() {
        StringBuilder positionStr = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            positionStr.append(POSITION_MARK);
        }

        return positionStr.toString();
    }

    private int position = 1;

    public void move(){
        this.position += 1;
    }

}
