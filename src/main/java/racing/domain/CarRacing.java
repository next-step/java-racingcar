package racing.domain;

import racing.view.Display;

public class CarRacing {
    private ParticipateCars participateCars;
    private Display display;

    public CarRacing(ParticipateCars participateCars) {
        this.participateCars = participateCars;
        this.display = display;
    }

    public void startRacing(int racingCount) {
        this.participateCars.moveCar();
    }

    public String presentWinner(){
        return this.participateCars.winner();
    }

    public ParticipateCars showParticipateCars() {
        return this.participateCars;
    }
}
