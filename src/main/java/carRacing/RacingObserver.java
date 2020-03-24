package carRacing;

import carRacing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingObserver {

    ResultView resultView;
    List<Integer> vehiclePositions;

    public RacingObserver(List<Vehicle> vehicles) {
        resultView = new ResultView();
        vehiclePositions = observe(vehicles);
    }

    public void tracking(List<Vehicle> vehicles) {
        vehiclePositions = observe(vehicles);
        resultView.showGameState(vehiclePositions);
    }

    public List<Integer> observe(List<Vehicle> vehicles) {
        ArrayList<Integer> positions = new ArrayList<>();

        int i = positions.size();
        for (Vehicle vehicle : vehicles) {
            positions.add(i++, vehicle.inquiryPosition());
        }
        return positions;
    }
}
