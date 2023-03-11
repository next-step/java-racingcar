package racing;

public class CarRaceRehearsal {
    public static void main(String[] args) {
        Cars cars;
        Winners winners;
        CarRace carRace = new CarRace();
        CarInputInfo carInputInfo = new CarInputInfo();

        cars = carInputInfo.getCarEntry();
        int trackCount = carInputInfo.getTrackCount();

        for (int i = 0; i < trackCount; i++) {
            carInputInfo.racing(cars);
        }

        winners = carRace.getWinners(cars);
        carInputInfo.winnersDisplay(winners);
    }
}
