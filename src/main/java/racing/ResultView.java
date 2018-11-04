package racing;

import java.util.List;

public class ResultView {
    public static void watchRace(RacingGame racingGame){
        System.out.println("실행결과");
        for (int i = 0 ; i < racingGame.getTime(); i++){
            watchTrace(racingGame.move());
        }

        getRaceWinners(racingGame);
    }

    private static void getRaceWinners(RacingGame racingGame) {
        int max = 0;
        String result = "";
        List<Car> cars = racingGame.getCars();

        for(Car car : cars){
            max = getMax(max, car.getPosition());
        }
        for(Car car : cars){
            result += getWinner(max,  car);
        }
        result = result.substring(0, result.length() -1 );
        result += "가 최종 우승했습니다.";
        System.out.println(result);
    }

    private static String getWinner(int max, Car car) {
        if(max ==  car.getPosition()){
          return car.getName()+ ",";
        }
        return "";
    }

    private static int getMax(int max, int right) {
        return max < right ? right : max;
    }

    private static void watchTrace(List<Car> cars) {
        for(int j =0; j < cars.size(); j++){
            printName(cars.get(j));
            drawTrace(cars.get(j));
        }
        System.out.println();
    }

    private static void printName(Car car) {
        System.out.print(car.getName() +" : ");
    }

    private static void drawTrace(Car car) {
        for (int k = 0; k < car.getPosition(); k++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
