package racing;

public class CarRaceRehearsal {
    public static void main(String[] args) {
        Cars cars;
        Winners winners;
        CarRace carRace = new CarRace();
        CarInputInfo carInputInfo = new CarInputInfo();
        CarOutputInfo carOutputInfo = new CarOutputInfo();

        cars = carInputInfo.getCarEntry();
        int trackCount = carInputInfo.getTrackCount();

        for (int i = 0; i < trackCount; i++) {
            carRace.racing(cars);
            carOutputInfo.display(cars);
            System.out.println();
        }

        winners = carRace.getWinners(cars);
        carOutputInfo.winnersDisplay(winners);
    }


}
