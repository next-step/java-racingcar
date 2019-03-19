package racing.domain;

public class Car {

    private static final int CRITERION_TO_MOVE = 4;
    private int position = 0;
    private String name;

    public Car(int position, String name){
        this.position = position;
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= CRITERION_TO_MOVE) {
            this.position++;
        }
    }

    public int getPosition() { return position; }
    public String getName() { return name; }

    @Override
    public String toString() {
        StringBuffer tmp = new StringBuffer();
        tmp.append(name + " : ");
        for(int i = 0 ; i < position ; i++) {
            tmp.append("-");
        }
        return tmp.toString();
    }

}
