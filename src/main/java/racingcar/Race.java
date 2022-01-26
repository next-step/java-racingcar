package racingcar;
import java.util.Random;

public class Race {
    public static void execute() {
        String[] carNames = InputView.getName();
        if(!InputView.checkCarName(carNames)){
            System.out.println("자동차 이름은 5자를 초과할 수 없습니다.");
            return ;
        }
        int[] cars = new int[carNames.length];
        int times = InputView.getTimes();
        repeatGame(cars,carNames,times);
        OutputView.printWinners(carNames, cars);
    }

    public static void repeatGame(int[] cars, String[] carNames, int times) {
        while((times--)>0){
            for(int i=0; i< cars.length; i++){
                int randomNumber=Race.getRandomNumber();
                Race.compareWithFour(cars,i,randomNumber);
            }
            OutputView.printCurrent(carNames, cars);
            System.out.println();
        }
    }

    public static int getRandomNumber() {
        int randomNumber = new Random().nextInt(10);
        return randomNumber;
    }

    public static void compareWithFour(int[] cars, int idx, int randomNumber){
        if(randomNumber>=4)
            cars[idx]++;
        return;
    }
}
