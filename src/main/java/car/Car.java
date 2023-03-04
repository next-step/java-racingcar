package car;

import java.util.*;

public class Car {

    private CarEntity carEntity;
    private Map<String, Integer> scoreMap = new HashMap<>();

    public void carNameChk(String inputData){
        if(inputData.length() > 4) throw new IllegalArgumentException("이름초과");
    }

    public void carRacingStart(String carList, int count){

        // play
        for (int i = 0; i < count; i++){
            carRacingOrder(carList, i);
        }
        // result
        carRacingResult();
    }

    public void carRacingOrder(String carList, int i){
        String[] carName = carList.split(",");

        // car list
        for(String car : carName){
            carRacingPlay(car, i);
        }
        System.out.println();
    }

    public void carRacingPlay(String car, int i){
        // carName check
        carNameChk(car);

        // entity
        CarEntity carEntity = new CarEntity();
        carEntity.setCarName(car);
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if (randomNum > 3) carEntity.setNumber(+1);

        // score
        carRacingScoreManagement(carEntity);

        // message
        carRacingMessage(carEntity);
    }

    public void carRacingScoreManagement(CarEntity carEntity){
        if(scoreMap.get(carEntity.getCarName()) == null) scoreMap.put(carEntity.getCarName(), 0);
        scoreMap.put(carEntity.getCarName()
                , scoreMap.get(carEntity.getCarName())+carEntity.getNumber());
    }

    public void carRacingMessage(CarEntity carEntity){
        StringBuilder carRacingScore = new StringBuilder();
        for(int i = 0; i < scoreMap.get(carEntity.getCarName()); i++){
            carRacingScore.append("-");
        }
        System.out.println(carEntity.getCarName() + " : " + carRacingScore.toString());
    }

    public void carRacingResult() {
        int maxValue = Collections.max(scoreMap.values());
        List<String> winnerList = new ArrayList<>();

        for(String key : scoreMap.keySet()) {
            if(maxValue == scoreMap.get(key)) {
                winnerList.add(key);
            }
        }
        System.out.println("최종 우승자 : " + winnerList);
    }
}
