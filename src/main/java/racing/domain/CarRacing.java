package racing.domain;

import racing.view.Display;

public class CarRacing {
    private ParticipateCars participateCars;

    public CarRacing(ParticipateCars participateCars) {
        this.participateCars = participateCars;
    }

    public void startRacing() {
        this.participateCars.moveCar();
    }

    public String presentWinner(){
        return this.participateCars.winner();
    }

    public ParticipateCars showParticipateCars() {
        return this.participateCars;
    }
}
