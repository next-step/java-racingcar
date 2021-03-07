package step3.controller;

import step3.validation.InputValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CarController {

    private int totalCar;
    private int attemptCount;
    private static final String ADVANCE = "-";
    private final Random random = new Random();
    private InputValidation inputValidation = new InputValidation();

    public CarController(int totalCar, int attemptCount) {
        this.attemptCount = attemptCount;
        this.totalCar = totalCar;
    }


    public String getSumAdvance() {
        String s = "";
        for(int i = 0 ; i < this.attemptCount; i++ ){
            if (inputValidation.isRandomValueMoreThenFour(random.nextInt(10))) {
                s += ADVANCE;
            }
        }
        return s;
    }
    public List<String> getListAdvanceOfCar() {
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < this.totalCar; i++) {
            list.add(getSumAdvance());
        }
        return list;
    }

    public HashMap<Integer, List<String>> getEachCarAdvance() {
        HashMap<Integer, List<String>> resultMap = new HashMap<>();
        for (int i = 0 ; i < this.attemptCount; i++) {
            resultMap.put(i, getListAdvanceOfCar());
        }
        return resultMap;
    }
}
