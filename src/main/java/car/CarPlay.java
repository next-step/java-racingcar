package car;

import java.util.*;

public class CarPlay {

    private List<CarEntity> cars = new ArrayList<>();

    public void carNameCheck(String inputData) {
        if (inputData.length() > 4) {
            throw new IllegalArgumentException("이름초과");
        }

        if (inputData == null || inputData.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void carRacingStart(String carList, int count) {
        for (int i = 0; i < count; i++) {
            carRacingPlay(carList, i);
            System.out.println();
        }
        carRacingResult();
    }

    public void carRacingPlay(String carList, int i) {
        String[] carName = carList.split(",");
        for (int j = 0; j < carName.length; j++) {
            CarEntity carEntity = new CarEntity();

            carNameCheck(carName[j]);
            carEntity.setCarName(carName[j]);

            if (i == 0) {
                carEntity.setNumber(racingResult(10));
                cars.add(j, carEntity);
            }

            if (i > 0) {
                carEntity.setNumber(racingResult(10) + cars.get(j).getNumber());
                cars.set(j, carEntity);
            }
            carRacingMessage(j);
        }
    }

    public void carRacingMessage(int i) {
        StringBuilder carRacingScore = new StringBuilder();
        for (int j = 0; j < cars.get(i).getNumber(); j++) {
            carRacingScore.append("-");
        }
        System.out.println(cars.get(i).getCarName() + " : " + carRacingScore);
    }

    public void carRacingResult() {
        List<String> winnerList = new ArrayList<>();
        int maxScore = maxScoreCalculate();

        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getNumber() == maxScore){
                winnerList.add(cars.get(i).getCarName());
            }
        }
        System.out.println("최종 우승자 : " + winnerList);
    }
    public int maxScoreCalculate() {
        int maxValue = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (maxValue < cars.get(i).getNumber())
            {
                maxValue = cars.get(i).getNumber();
            }
        }
        return maxValue;
    }

    public int racingResult(int maxRange) {
        Random random = new Random();
        int result = 0;

        if (random.nextInt(maxRange) > 3)
        {
            result ++;
        }
        return result;
    }
}
