package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing{
    private List<RacingCar> list;
    private Map<RacingCar, Integer> rankMap;

    public Racing(String[] racingCars){
        list = new ArrayList<>();
        for(String racingCarName : racingCars){
            RacingCar racingCar = new RacingCar(racingCarName);
            list.add(racingCar);
        }
    }

    public void printFinalWinner(){
        rankMap = new HashMap<>();
        int maxiMumNumber = -1;
        for(RacingCar racingCar1 : list){
            int tempMaxiMumNumber = racingCar1.compareRacingCarListWithNum(list);
            if(maxiMumNumber < tempMaxiMumNumber){
                maxiMumNumber = tempMaxiMumNumber;
            }
            rankMap.put(racingCar1, tempMaxiMumNumber);
        }
        StringBuilder sb = new StringBuilder();
        String line = "최종 우승자: ";
        sb.append(line);
        for(RacingCar racingCar1 : list){
            if(rankMap.get(racingCar1).equals(maxiMumNumber)){
                sb.append(racingCar1.whoAmI());
                sb.append(", ");
            }
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 2));
    }

    public void run(int tryCount){
        System.out.println("실행 결과");
        int tryCountStart = 0;
        while(tryCountStart < tryCount){
            for(RacingCar racingCar : list){
                racingCar.run();
                racingCar.print();
            }
            tryCountStart++;
            System.out.println();
        }
    }
}
