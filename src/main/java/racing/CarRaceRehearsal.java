package racing;

public class CarRaceRehearsal {
    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        CarInputInfo carInputInfo = new CarInputInfo();
        CarOutputInfo carOutputInfo = new CarOutputInfo();

        Cars cars = carInputInfo.getCarEntry();
        int trackCount = carInputInfo.getTrackCount();

        for (int i = 0; i < trackCount; i++) {
            carRace.racing(cars);
            carOutputInfo.display(cars);
        }

        Winners winners = carRace.getWinners(cars);
        carOutputInfo.winnersDisplay(winners);
    }
}
