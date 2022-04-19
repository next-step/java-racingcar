package racingCar;

import java.util.List;

public class StartGame {

    public void racingCarGame(int n, int m, List<String> cars){
        while(m>0){
            for (int i =0; i < n; i++) {
                if(validationAdvance(randomNumber())){
                   moveCar(cars, i);
                }
                ResultView.result(cars, i);
            }
            System.out.println("");
            m--;
        }
    }

    public int randomNumber(){
        return (int) (Math.random()*10);
    }

    public Boolean validationAdvance(int number){
        if(number >=4){
            return true;
        }
        return false;
    }

    public void moveCar(List<String> cars, int i){
        cars.set(i, cars.get(i)+"-");
    }
}
