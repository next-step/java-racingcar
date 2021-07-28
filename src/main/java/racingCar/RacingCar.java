package racingCar;

public class RacingCar {
    private int drivenDistance;

    public RacingCar() {
        this.drivenDistance = 0;
    }

    public void goForward(){
        this.drivenDistance++;
    }

    public int showDrivenDistance(){
        return this.drivenDistance;
    }
}
