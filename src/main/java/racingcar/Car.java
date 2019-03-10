package racingcar;

public class Car {
    private int id;
    private int position;

    public Car(int id) {
        this.id = id;
        this.position = 0;
    }

    public void move(int randomValue) {
        if (randomValue > 4) {
            this.position += 1;
        }
    }

    public String displayPosition() {
        String result = id+": ";

        for (int i = 0; i < this.position; i++) {
            result += "-";
        }

        return result;
    }

    public int getPosition() {
        return position;
    }
}