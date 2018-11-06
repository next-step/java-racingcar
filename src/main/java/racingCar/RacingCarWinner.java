package racingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarWinner {


    //결과값 정렬하기(내림차순으로).
    public static List<Car> sortingList(List<Car> carList) {
        Collections.sort(carList);
        return carList;
    }

    // parameter list 는 내림차순으로 sorting 된 list 이다.
    // 중복의 우승자가 있는지 확인한다.
    public static List<Car> winnerList(List<Car> carList){
       List<Car> winners = new ArrayList<Car>();
       winners.add(carList.get(0)); //첫번째 우승자 Add.

        int i=1;
        while(carList.get(0).isEquals(carList.get(i))){
            winners.add(carList.get(i)); //중복 우승자 Add
            i++;
        }

       return winners;
    }

}
