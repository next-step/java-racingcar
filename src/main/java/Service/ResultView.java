package Service;

public class ResultView {


    public void printCarLocation(CarRace carRace, int attempts) {
        for (int i = 0; i < attempts; i++) {
            convertCarLocation(carRace);
        }
    }

    public void convertCarLocation(CarRace carRace) {
        carRace.updateCurrentLocation();
        for (int i = 0; i < carRace.getRacingCars().size(); i++) {
            for (int j = 0; j < carRace.getRacingCars().get(i).getCurrentLocation(); j++) {
                System.out.print(carRace.getRacingCars().get(i).getName() + " : " + "-");
            }
            System.out.println();
        }
    }
}
