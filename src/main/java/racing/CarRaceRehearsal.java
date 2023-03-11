package racing;

import java.util.List;

public class CarRaceRehearsal {
    public static void main(String[] args) {
        CarRace carRace;
        CarInputInfo carInputInfo = new CarInputInfo();
        List<Car> winners;

        carRace = carInputInfo.getCarEntry();
        int trackCount = carInputInfo.getTrackCount();

        for (int i = 0; i < trackCount; i++) {
            carInputInfo.racing(carRace.getCars());
        }

        winners = carRace.getWinners();
        carInputInfo.winnersDisplay(winners);
    }
}
