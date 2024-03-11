package carRace;

import static carRace.Car.createCar;

import java.util.List;

public class main {

    public static void main(String[] args) {
        RaceHost raceHost = new RaceHost(0,0);
        raceHost.inputRaceInformation();

        List<Car> carList = createCar(raceHost.carMount());

        raceHost.playGame(carList);
        raceHost.printRaceInfo(carList);
    }
}
