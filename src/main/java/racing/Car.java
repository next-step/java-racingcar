package racing;

public class Car {
    private static int ZERO = 0;

    private String name;
    private String movingPositionCursor = "";
    private int position;

    public Car(String name){
        validateNameUnderFive(name);
        this.position = ZERO;
        this.name = name;
    }

    private void validateNameUnderFive(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 다섯자리 이하만 가능합니다");
        }
    }

    public void move(){
        this.position++;
        this.movingPositionCursor += "-";
    }

    public int getPosition(){
        return this.position;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return name + ':' + movingPositionCursor;
    }
}
