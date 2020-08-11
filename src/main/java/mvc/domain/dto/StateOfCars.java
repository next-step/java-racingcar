package mvc.domain.dto;


import java.util.List;

public class StateOfCars {
    private final List<CarState> states;

    private StateOfCars(List<CarState> states) {
        this.states = states;
    }

    public List<CarState> getStates() {
        return this.states;
    }

    public static StateOfCars makeCarStateList(List<CarState> states) {
        return new StateOfCars(states);
    }
}
