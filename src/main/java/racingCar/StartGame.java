package racingCar;

import java.util.List;

public class StartGame {

    public void racingCarGame(int n, int m, List<String> cars){
        while(m>0){
            for (int i =0; i < n; i++) {
                moveCar(randomNumber(),cars, i);
                ResultView.result(cars, i);
            }
            System.out.println("");
            m--;
        }
    }

    public int randomNumber(){
        return (int) (Math.random()*10);
    }

    public void moveCar(int number, List<String> cars, int i){
        if (number >=4){
            cars.set(i, cars.get(i)+"-");
        }
    }
}
