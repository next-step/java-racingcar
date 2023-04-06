import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CarRace {
    private List<Car> carList;
    private final int countOfMove;

    //외부에서 생성자 호출 막기
    private CarRace(List<Car> carList, int countOfMove){
        this.carList = carList;
        this.countOfMove = countOfMove;
    }

    public static CarRace initRace(int numberOfCar, int countOfMove) {
        List<Car> carList = IntStream.range(0, numberOfCar)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());

        return new CarRace(carList, countOfMove);
    }

    public static CarRace input(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        return initRace(a,b);
    }

    public int getCountOfMove() {
        return countOfMove;
    }

    public List<Car> getCarList() {
        return carList;
    }
    public void race() {
        for(int i=0; i<countOfMove; i++) {
            carList.stream().forEach(car -> car.moveCar(car.moveOrNot()));
            racePrint(i+1);
        }
    }

    public void racePrint(int count){
        System.out.println(count + "회차");
        for(int i=0; i<carList.size(); i++){
            int move = carList.get(i).getMove();
            for(int j=0; j<move; j++){
                System.out.print("-");
            }
            System.out.println();
        }

    }


}
