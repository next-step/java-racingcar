package racingcar.domain;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MIN_MOVING_NUMBER = 4;
    private static final int DEFAULT_POSITION = 0;
    public String name;
    public int move;

    public Car(String name){
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int move) {
        isValidaName(name);
        this.name = name;
        this.move = move;
    }
    
    public int getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    //전진
    public void updateMove(){
        move ++;
    }

    //전진여부를 판단 (랜덤넘버가 4이상일때 전진 호출)
    public void judgeMoving(int randomcnt) {
        if(randomcnt > MIN_MOVING_NUMBER)
            updateMove();
    }
    
    //차이름 정합성 확인
    public static void isValidaName(String name)
    {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 한다.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("입력된 이름이 빈값입니다.");
        }
    }

    @Override
    public String toString() {

        String print = "-";
        String output = name + " : " + print.repeat(move);
        return output.toString();
    }
}
