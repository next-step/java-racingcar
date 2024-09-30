public class RacingCar {
    private int status;
    private String name;

    public RacingCar() {
        this.status = 0;
        this.name = "";
    }

    public RacingCar(int status) {
        this.status = status;
        this.name = "";
    }

    public RacingCar(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void move(int num) {
        if (num >= 4) {
            this.status++;
        }
    }
}
