package car;

public class Car {
    private int position;
    private String mark = "";

    public Car() {
        this.position = 0;
    }

    public void moveAndRecord(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
            this.mark += "-";
        }
    }

    public int currentPosition() {
        return this.position;
    }

    public String getMark() {
        return this.mark;
    }

}
