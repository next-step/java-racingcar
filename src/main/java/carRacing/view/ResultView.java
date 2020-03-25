package carRacing.view;


import carRacing.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void showResult() {
        System.out.println();
        System.out.print(Constants.INFORMATION_MESSAGE_RESULT);
    }

    public void showGameState(List<Integer> gameState) {
        System.out.println();
        new ArrayList<>(gameState).forEach(position -> {
            System.out.println(carState(position));
        });
    }

    private String carState(Integer position) {
        String[] result = new String[position];
        Arrays.fill(result, "-");

        return Arrays.stream(result).collect(Collectors.joining());
    }
}
