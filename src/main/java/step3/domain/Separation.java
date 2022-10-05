package step3.domain;

import java.util.Arrays;
import java.util.List;

public class Separation {

    private static final String SEPARATOR = ",";

    public List<String> nameSeparation(String inputName) {
        return Arrays.asList(inputName.split(SEPARATOR));
    }

    public String winnerSeparation(List<Car> carList) {
        String names = "";
        for (int i = 0; i < carList.size(); i++) {
            names = addWinner(carList, names, i);
        }
        return names;
    }

    private static String addWinner(List<Car> carList, String names, int i) {
        names += carList.get(i).getName();
        if (i != carList.size() - 1) {
            names += SEPARATOR;
        }
        return names;
    }
}
