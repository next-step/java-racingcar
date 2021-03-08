package step3;

import step3.validation.InputValidation;

import java.util.*;

public class RacingCarGame {

    private static final String ADVANCE = "-";
    private int totalCar;
    private int attemptCount;
    private final Random random = new Random();

    public RacingCarGame(int totalCar, int attemptCount) {
        this.attemptCount = attemptCount;
        this.totalCar = totalCar;
    }

    public String getSumAdvance() {
        String s = "";
        for(int i = 0 ; i < this.attemptCount; i++ ){
            if (isRandomValueMoreThenFour(random.nextInt(10))) {
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

    public RacingCarGame(int totalCar, int attemptCount) {
        this.totalCar = totalCar;
        this.attemptCount = attemptCount;
    }



}
