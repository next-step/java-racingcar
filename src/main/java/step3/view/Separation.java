package step3.view;

import step3.domain.Winner;

import java.util.Arrays;
import java.util.List;

public class Separation {

    private static final String SEPARATOR = ",";

    public List<String> nameSeparation(String inputName) {
        return Arrays.asList(inputName.split(SEPARATOR));
    }

    public String winnerSeparation(Winner winner) {
        String outputWinner = "";
        for (int i = 0; i < winner.getWinnerList().size(); i++) {
            outputWinner
                    += (winner.getWinnerList().get(i).getName()
                    + addSeparatorCheck(i, winner.getWinnerList().size()));
        }
        return outputWinner;
    }

    private String addSeparatorCheck(int loopCount, int size) {
        String separator = "";
        if (size != 1 && loopCount != size - 1) {
            separator = SEPARATOR;
        }
        return separator;
    }
}
