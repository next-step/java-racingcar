package racingcar;

public class Car {
    private static final int STATUS_LINE = 0;
    private static final int MIN_RANDOM_NUMBER = 3;

    private int statusLine;

    public Car() {
        this.statusLine = STATUS_LINE;
    }

    public void move(int random){
        if(MIN_RANDOM_NUMBER < random){
            statusLine++;
        }
    }

    public int getStatusLine(){
        return statusLine;
    }

}
