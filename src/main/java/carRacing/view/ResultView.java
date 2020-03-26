package carRacing.view;


import carRacing.Constants;
import carRacing.Domain.Car;
import carRacing.Domain.Vehicle;
import carRacing.Domain.Vehicles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ResultView {

    public void showResult() {
        System.out.println();
        System.out.print(Constants.INFORMATION_MESSAGE_RESULT);
    }

    public void showGameState(Vehicles vehicles) {
        System.out.println();

        vehicles.getVehicles().stream().forEach(vehicle -> {
            System.out.println(vehicle.getName() + " : " + showVehicleState(vehicle.inquiryPosition()));
        });
    }

    private String showVehicleState(Integer position) {
        String[] result = new String[position];
        Arrays.fill(result, "-");

        return Arrays.stream(result).collect(Collectors.joining());
    }


    public void showWinner(Vehicles vehicles) {
        System.out.println(vehicles.findWinner().stream().collect(Collectors.joining(", ")) + Constants.INFORMATION_MESSAGE_WINNER);;
    }
}
