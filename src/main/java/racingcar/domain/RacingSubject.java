package racingcar.domain;

import java.util.HashSet;
import java.util.Set;

class RacingSubject implements Subject<Integer> {
    private final Set<Observer<Integer>> observers = new HashSet<>();

    @Override
    public void addObserver(Observer<Integer> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Integer> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Integer currentRacing) {
        observers.forEach(observer -> observer.observe(currentRacing));
    }
}
