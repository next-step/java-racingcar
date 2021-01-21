package racingcar;

import java.util.*;

public class RacingGameController {

    private final int LOWER_BOUND_MOVE = 4;

    private ArrayList<RacingCar> cars = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private int numberOfRound;


    public void getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");


        String input = sc.nextLine();

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] inputs = input.split(",");
        for (int i=0; i<inputs.length; i++){
            cars.add(new RacingCar(inputs[i]));
        }
    }

    public void getRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        numberOfRound = sc.nextInt();

    }

    public void findWinner() {

        int maxStatus = cars.get(0).getStatus();
        for (int i=1; i<cars.size(); i++) {
            if(maxStatus < cars.get(i).getStatus()) maxStatus = cars.get(i).getStatus();
        }
        printWinners(maxStatus);
    }

    private void printWinners(int maxStatus) {
        System.out.print("최종 우승자: ");
        List<String> winners = new ArrayList<>();
        for(int i=0; i<cars.size(); i++) {
            if(cars.get(i).getStatus() == maxStatus) {
               winners.add(cars.get(i).getName());
            }
        }
        String result = String.join(", ",winners);
        System.out.println(result);
    }


    public int getRandomNumber() {
        Random rand = new Random();

        return rand.nextInt(10);
    }

    public void playRound() {
        for(int i=0; i<cars.size(); i++) {
            moveEachCar(cars.get(i));
        }
        printAllCarStatus();
        System.out.println();
    }

    public void printAllCarStatus() {
        for (int i=0; i<cars.size(); i++) {
            String name = cars.get(i).getName();
            int status = cars.get(i).getStatus();
            printEachCarStatus(name, status);
        }
    }

    public void printEachCarStatus(String name, int status) {
        System.out.print(name+" : ");
        for (int j=0; j<status; j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void start() {
        getCarsName();
        getRound();

        System.out.println("실행 결과");
        for(int i=0; i<numberOfRound; i++) {
            playRound();
        }

        findWinner();
    }

    public void moveEachCar(RacingCar racingCar) {
        if(getRandomNumber() >= LOWER_BOUND_MOVE) {
            racingCar.movingForward();
        }
    }
}
