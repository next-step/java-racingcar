package step4.model;

public class Car {
    private String name;
    private int move;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    public void go(){
        this.move = move+1;
    }
}
