package RacingCar;
import java.util.*;

public class RacingCar {

    public void racingCar(){

        ArrayList<Car> carList =  new ArrayList<Car>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
        String inputValue = scanner.nextLine();
        String[] splitValue = inputValue.split(",");

        for(int i=0; i < splitValue.length; i++) {
            carList.add(new Car(splitValue[i]));
        }

        System.out.print("시도할 횟수는 몇 회인가요?\n");
        int count = Integer.parseInt(scanner.nextLine());

        //게임실행
        startGame(carList, count);
        //우승자 확인
        System.out.println("최종우승자: " + getWinner(carList));

    }

    public void startGame(List<Car> carList, int count){

        for(int i=0; i < count; i++) {
            for (Car car : carList) {
                car.updatePosition(car.getRandomValue());
                printRace(car.getName(), car.getPosition());
            }
            System.out.println();
        }

    }

    public String getWinner(List<Car> carList){

        List<String> winner = new ArrayList<>();
        int maxPosition = getMaxPosition(carList);

        for (Car car : carList) {
            if (car.position == maxPosition) {
                winner.add(car.name);
            }
        }

        return winner.toString();
    }

    public void printRace(String name, int position){
        String print = "-";
        System.out.println(name+" : "+print.repeat(position));
    }

    public int getMaxPosition(List<Car> carList){

        int maxPositionValue = 0;

        for (Car car : carList) {
            if (car.getPosition() > maxPositionValue) {
                maxPositionValue = car.getPosition();
            }
        }

        return maxPositionValue;
    }
}