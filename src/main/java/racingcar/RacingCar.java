package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class RacingCar {
    void racingCar(String inputSentence,String racingCnt){
        String[] car_names = inputSentence.replace(" ","").split(",");
        int[] speed = new int[car_names.length];
        for (int i = 0; i <Integer.valueOf(racingCnt) ; i++) {
            System.out.println("---------------"+(i+1)+"번째-------------------");
            racings(car_names.length,speed,car_names);
        }
        for (int i = 0; i < speed.length; i++) {
            speedList.add(speed[i]);
        }
        ArrayList carOrders = calcRank(speedList);
        System.out.print("최종우승자 : ");
        for (int i = 0; i < carOrders.size(); i++) {
            String winnerIs = "";
            if(i==0){
                winnerIs = "최종우승자 : ";
            }
            int idx = Integer.valueOf(carOrders.get(i).toString());

            String comma = stringProvide(i,carOrders.size());
            System.err.print(winnerIs + car_names[idx] + comma);
        }
    }
    String stringProvide(int i,int size){
        String comma ="";
        if(i==0){
           comma=  " ,";
        }
        if(i==(size+1)){
           comma=  " ,";
        }
        return comma;
    }
    // 석차 계산
    public ArrayList calcRank(ArrayList<Integer> speedList) {
        ArrayList<Integer> carOrder = new ArrayList<>();
        for (int i = 0; i < speedList.size(); i++) {
            int rank = forRank(speedList, i);
            if(rank==1){
                carOrder.add(i);
            }
        } // end outer for
        return carOrder;
    } // calcRank END
    int forRank(ArrayList<Integer> speedList,int i){
        int rank = 1;
        for (int j = 0; j < speedList.size(); j++) {
            // 일단 나를 1등이라고 가정하고, 다른 값들과 비교하여 작으면 rank 값을 하나씩 올린다.
            // 동점 처리 : 공동 1등인 경우 모두 1등 처리, 그 다음은 3등 처리.
            if (speedList.get(i) < speedList.get(j)) {
                rank++;
            } // end if
        } // end inner for
        return rank;

    }
    ArrayList<Integer> speedList = new ArrayList<Integer>();
    void racings(int length, int[] speed, String[] car_names){
        Random random = new Random();
        for (int i = 0; i <length ; i++) {
            int randomInt = random.nextInt(10);
            if(randomInt>=4){
                speed[i]++;
            }
        }
        for (int i = 0; i < length; i++) {
            String racingIng = racingIng(speed[i]);
            System.out.println(car_names[i]+" = "+racingIng );
        }
    }
    String racingIng(int speed){
        String ing = "";
        for (int i = 0; i < speed; i++) {
            ing += "-";
        }
        return ing;
    }


}
