package carRacing;

import carRacing.Controller.InGameController;
import carRacing.Domain.Vehicle;
import carRacing.view.InputView;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Vehicle> raceVehicle = InGameController.run(InputView.readyToInteraction());


    }
}
