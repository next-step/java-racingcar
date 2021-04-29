package ugemang.nextstep.service;

import ugemang.nextstep.domain.message.RacingGameMessageEnum;
import ugemang.nextstep.domain.car.*;
import ugemang.nextstep.domain.curcuit.Curcuit;
import ugemang.nextstep.domain.curcuit.Round;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGameServiceImpl implements RacingGameService {
    private Curcuit curcuit;

    @Override
    public void inputGameInformation() {
        List<Car> cars = getCars(getCarNames(getPlayersName()));
        this.curcuit = new Curcuit(new Round(getRound()),new Cars(cars));
    }

    @Override
    public void start() {
        Round round = getCurcuit().getRound();
        for (int i = 0; i< round.getRound(); i++){
            lap(i);
        }
    }

    @Override
    public void lap(int count) {
        getCurcuit().lap(count);
        List<Car> cars = getCurcuit().getPlayers().getCars();
        for(Car i : cars){
            int index = i.getDistanceList().size() - 1;
            StringBuffer sb = new StringBuffer();
            sb.append(i.getName());
            sb.append(" : ");
            sb.append(i.getDistance(index));
            print(sb);
        }
        System.out.println();
    }

    @Override
    public Winner getWinner() {
        return getCurcuit().getWinner();
    }

    @Override
    public void print(StringBuffer str) {
        System.out.println(str.toString());
    }

    private String getPlayersName(){
        print(new StringBuffer().append(RacingGameMessageEnum.Q1.getMessage()));
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private Integer getRound(){
        print(new StringBuffer().append(RacingGameMessageEnum.Q2.getMessage()));
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private List<Car> getCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        carNames.forEach(name-> cars.add(new Car(name)));
        return cars;
    }

    private List<String> getCarNames(String str) {
        List<String> carNames = new ArrayList<>(Arrays.asList(str.split(",")));
        return carNames;
    }

    public Curcuit getCurcuit() {
        return curcuit;
    }
}
