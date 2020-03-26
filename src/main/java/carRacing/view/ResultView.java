package carRacing.view;


import carRacing.Constants;
import carRacing.Domain.Car;
import carRacing.Domain.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ResultView {

    public void showResult() {
        System.out.println();
        System.out.print(Constants.INFORMATION_MESSAGE_RESULT);
    }

    public void showGameState(List<Vehicle> gameState) {
        System.out.println();

        gameState.stream().map(Vehicle::inquiryPosition).forEach(position -> {
            System.out.println(showCarState(position));
        });
    }

    private String showCarState(Integer position) {
        String[] result = new String[position];
        Arrays.fill(result, "-");

        return Arrays.stream(result).collect(Collectors.joining());
    }
}
