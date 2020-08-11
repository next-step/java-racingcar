package cc.oakk.racing.domain;

import cc.oakk.racing.view.printer.Printable;
import cc.oakk.racing.view.printer.Printer;

import java.util.*;

public class Ranking implements Printable<Ranking> {
    public static final int FIRST_RANK = 1;

    private Map<Integer, List<Car>> ranks;
    private Set<Car> carSet;

    public Ranking(List<Car> cars) {
        initCarSet(cars);
        initRanksMap(cars);
    }

    public List<Car> getWinner() {
        return getRankAt(FIRST_RANK);
    }

    public List<Car> getRankAt(int rankIndex) {
        if (rankIndex < 1 || rankIndex > size()) {
            throw new IndexOutOfBoundsException("Index should be between 1 and size of ranking.");
        }

        return ranks.get(rankIndex);
    }

    public int size() {
        return carSet.size();
    }

    private void initCarSet(List<Car> cars) {
        carSet = new TreeSet<>();
        carSet.addAll(cars);

        carSet = Collections.unmodifiableSet(carSet);
    }

    private void initRanksMap(List<Car> cars) {
        ranks = new HashMap<>();
        cars.forEach(car -> {
            int rank = calculateRank(car);
            List<Car> rankList = getRankList(rank);
            rankList.add(car);
        });

        ranks = Collections.unmodifiableMap(ranks);
    }

    private int calculateRank(Car car) {
        return (int) carSet.stream()
                .filter(c -> car.compareTo(c) < 1)
                .count();
    }

    private List<Car> getRankList(int key) {
        if (ranks.containsKey(key)) {
            return ranks.get(key);
        }

        List<Car> rankList = new ArrayList<>();
        ranks.put(key, rankList);
        return rankList;
    }

    @Override
    public void print(Printer<Ranking> printer) {
        printer.print(this);
    }
}
