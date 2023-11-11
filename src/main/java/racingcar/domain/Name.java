package racingcar.domain;

public class Position {

    private static final int START_INIT_VALUE = 1;
    private int number;

    public Position(){
        this.number = START_INIT_VALUE;
    }

    public  boolean isAtPosition(int number){
        return this.number == number;
    }

    public void addOnePosition(){
        ++this.number;
    }

    public int max(int number){
        return Math.max(this.number, number);
    }

    public int getNumber(){
        return this.number;
    }
}
