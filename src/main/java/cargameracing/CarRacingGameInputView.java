package cargameracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * View Role
 * @author minji
 */
public class CarRacingGameInputView {
    String[] carName;

    CarRacingGameInputView(String names) {
        this.carName = names.split(",");
    }

    public List<String> getCarName() {
        List<String> carNames = new ArrayList<String>();
        for (int i = 0; i < carName.length; i++){
            String name = carName[i];
            carNames.add(name);
        }
        return carNames;
    }
}
