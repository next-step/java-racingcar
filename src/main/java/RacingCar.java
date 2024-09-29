public class RacingCar {
    private int status;

    public RacingCar() {
        this.status = 0;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void move(int num) {
        if (num >= 4) {
            this.status++;
        }
    }
}
