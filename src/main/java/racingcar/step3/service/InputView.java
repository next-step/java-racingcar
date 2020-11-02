package racingcar.step3.service;

import racingcar.step3.domain.Car;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created : 2020-11-02 오전 8:25
 * Developer : Seo
 */
public class InputView {
    private Set<Car> cars;
    private int turns;

    public void setCars() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int number = scanner.nextInt();

        cars = new HashSet<>();
        for (int i = 1; i < number + 1; i++) {
            cars.add(new Car(i));
        }
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    public void setTurns() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.turns = scanner.nextInt();
    }

    public int getTurns() {
        return this.turns;
    }
}
