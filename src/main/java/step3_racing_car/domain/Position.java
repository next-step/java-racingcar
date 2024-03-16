package step3_racing_car.domain;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public int max(int other){
        if(this.value < other){
            return other;
        }
        return this.value;
    }

    public boolean isMatch(int other){
        return this.value == other;
    }

    public void move(int distance) {
        this.value += distance;
    }

    @Override
    public String toString() {
        return "-".repeat(this.value);
    }
}
