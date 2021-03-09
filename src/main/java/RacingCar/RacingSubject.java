package RacingCar;

import java.util.HashSet;
import java.util.Set;

class RacingSubject implements Subject<RacingResult> {

    @Override
    public void addObserver(Observer<RacingResult> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<RacingResult> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(RacingResult event) {
        observers.forEach(observer -> observer.observe(event));
    }

    private final Set<Observer<RacingResult>> observers = new HashSet<>();
}
