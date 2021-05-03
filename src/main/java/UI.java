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
        cars.setWinningCar();
        str.append(String.join(",", cars.getCarsNames()));
        str.append(UIMessage.NOTICE_WINNER.getMessage());
        System.out.println(str);
    }

}
