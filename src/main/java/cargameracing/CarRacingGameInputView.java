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

    public List<Name> getCarName() {
        List<Name> carNames = new ArrayList<Name>();
        for (int i = 0; i < carName.length; i++){
            Name name = new Name(carName[i]);
            carNames.add(name);
        }
        return carNames;
    }
}
