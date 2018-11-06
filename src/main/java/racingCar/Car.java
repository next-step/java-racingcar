package racingCar;


import java.util.List;


import static racingCar.RacingCarUtil.createRandomValue;
import static racingCar.RacingCarUI.showPosition;

public class Car implements Comparable<Car>{

    private static final int CONDITIONBOUNDARY=4;

    private String name;
    private int position;

    //생성자
    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    //차량 움직이기.
    public static Car[] moveCar(Car[] cars){
        for(Car car : cars){
            car.getPosition(move(createRandomValue()));
        }
        return cars;
    }

    //이동할지 말지 카운트 구하기
    public static int move(int randomValue) {
        int moveCount = 0;

        if (randomValue > CONDITIONBOUNDARY) {
            moveCount++;
        }

        return moveCount;

    }

    //이동 & 정지하는 로직
    public void getPosition(int moveCount) {
        position += moveCount;
    }

    //내림차순 정렬를 위해 재정의된 compareTo method.
    @Override
    public int compareTo(Car otherCar){
        Car tempCar=null;
        if(this.position > otherCar.position){
            return -1;
        }
        if(this.position == otherCar.position){
            return 0;
        }
        return 1;
    }

    // 비교대상과 동일하면 true , 아니면 false
    public boolean isEquals(Car otherCar){
        return this.position == otherCar.position;
    }

    //진행 결과값
    public String toString(){
        return this.name + " : " + showPosition(this.position);
    }

    // 우승자 list String으로 return 하기.
    public static String getResult(List<Car> winnerList){
        String result = winnerList.get(0).name;

        for(int i=1;i<winnerList.size();i++){
            result +=", " + winnerList.get(i).name;
        }
        return result;

    }

}
