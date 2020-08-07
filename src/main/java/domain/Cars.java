package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> carList;
    private final int playCnt;

    public static Cars of(String names, int carCnt, int playCnt) {
        Random random = new Random();
        DiceRoller diceRoller = new DiceRollerImpl(random);
        String[] split = names.split(",");

        List<Car> carList = IntStream.range(0, carCnt).boxed()
                .map(e -> new Car(diceRoller, split[e]))
                .collect(Collectors.toList());

        return new Cars(playCnt, carList);
    }

    public void play() {
        for (int i = 0; i < playCnt; i++) {
            for (Car car : carList) {
                car.printLength();
                System.out.println();
                if (i != playCnt-1) car.go();
            }
            System.out.println();
        }
        Referee referee = new Referee(carList);
        System.out.println(referee.getWinnersCarNames() + "가 최종 우승 했습니다.");
    }

    public Cars(int playCnt, List<Car> carList) {
        this.playCnt = playCnt;
        this.carList = carList;
    }



}
