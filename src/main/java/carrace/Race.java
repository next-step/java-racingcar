package carrace;

public class Race {

    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        PrintUI ui = new PrintUI();

        ui.inputView(carRace);
        carRace.startRaces();
        ui.resultView(carRace);
    }
}
