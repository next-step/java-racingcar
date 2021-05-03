import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    private static final Scanner scanner = new Scanner(System.in);
    Cars cars;

    public UI(Cars cars) {
        this.cars = cars;
    }

    public static String answer(UIMessage uiMessage) {
        uiMessage.println();
        return scanner.nextLine();
    }


    public void printGameResult(){
        for (Car car : cars.getCars()) {
            printCarDriving(car);
        }
        System.out.println();
    }

    private void printCarDriving(Car car){
        StringBuffer str = new StringBuffer();
        str.append(car.getName() + ": ");
        int distance = car.getDistance();
        while(distance-- > 0){
            str.append(UIMessage.NOTICE_CAR_RUN.getMessage());
        }
        System.out.println(str);
    }

    public void printWinner(){
        StringBuffer str = new StringBuffer();
        //todo 우승자의 주행거리가 count와 같지 않을 수 있다.
        //todo 우승자는 참가한 자동차들 중 주행거리가 가장 앞선 차로 정해야한다.
        cars.getWinningCar();
        str.append(String.join(",", cars.getCarsNames(new ArrayList<>())));
        str.append(UIMessage.NOTICE_WINNER.getMessage());
        System.out.println(str);
    }

}
