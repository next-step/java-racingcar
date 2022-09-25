package step3;

public class Car {

    private static final int MIN_NO = 0;
    private static final int MIN_BOUND_NO = 4;
    private static final int MAX_BOUND_NO = 9;
    private int position;

    public Car(){
        this(0);
    }

    public static Car withPosition(int position){
        return new Car(position);
    }

    private Car(int position){
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveWithRandomNo(int randomNo) {

        if(isInvalid(randomNo)){
            throw new IllegalStateException("숫자는 " + MIN_NO + "~" + MAX_BOUND_NO + " 사이여야 합니다.");
        }

        if(isMovable(randomNo)){
            this.position += 1;
        }
    }

    private boolean isInvalid(int randomNo) {
        return randomNo < MIN_NO
                || randomNo > MAX_BOUND_NO;
    }

    private boolean isMovable(int no) {
        return no >= MIN_BOUND_NO
                && no <= MAX_BOUND_NO;
    }

    public void moveWithStrategy(MoveStrategy moveStrategy){
        if(moveStrategy.movable()){
            this.position += 1;
        }
    }


}



