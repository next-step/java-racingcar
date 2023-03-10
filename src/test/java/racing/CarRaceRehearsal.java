package racing;

public class CarRaceRehearsal {
    public static void main(String[] args) {
        CarRace carRace;
        CarInputInfo carInputInfo = new CarInputInfo();

        carRace = carInputInfo.getCarEntry();
        int trackCount = carInputInfo.getTrackCount();

        for (int i = 0; i < trackCount; i++) {
            carRace.racing();
        }

        carRace.getWinners();
        carRace.winnersDisplay();
    }
}
