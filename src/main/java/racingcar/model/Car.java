package racingcar.model;

public class Car {

    public static final int RUNNING_CONDITION = 4;
    private int position;

    public void move(int status) {
        validateStatus(status);
        if(status >= RUNNING_CONDITION){
            position++;
        }
    }

    private void validateStatus(int status) {
        if( 0 > status || status > 9){
            throw new IllegalArgumentException(status + "은 잘못된 입력값입니다.");
        }
    }

    public int getPosition() {
        return position;
    }
}
