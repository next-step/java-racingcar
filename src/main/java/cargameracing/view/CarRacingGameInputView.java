package cargameracing.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * View Role
 * @author minji
 */
public class CarRacingGameInputView {
    private String[] carName;

    public CarRacingGameInputView(String names, int playCount) {
        this.carName = names.split(",");
    }

    public List<String> getCarName() {
        List<String> carNames = new ArrayList<String>();
        for (String name:carName){
            carNames.add(name);
        }
        return carNames;
    }
}
