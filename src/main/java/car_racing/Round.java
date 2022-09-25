package car_racing;

public class Round {
    private Integer count;

    public Round() {
        this.count = 0;
    }

    public void start() {
        this.count++;
    }

    public Integer count() {
        return count;
    }
}
