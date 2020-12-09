package racing;

public class CarRacing {
    private ParticipateCars participateCars;
    private Display display;

    public CarRacing(ParticipateCars participateCars, Display display) {
        this.participateCars = participateCars;
        this.display = display;
    }

    public void startRacing(int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            this.participateCars.moveCar();
            display.displayRacingResult(this.participateCars);
        }
    }

    public String presentWinner(){
        return this.participateCars.winner();
    }
}
