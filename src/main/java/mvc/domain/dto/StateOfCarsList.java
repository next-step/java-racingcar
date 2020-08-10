package mvc.domain.dto;


import java.util.List;

public class StateOfCarsList {
    private final List<CarState> states;

    private StateOfCarsList(List<CarState> states) {
        this.states = states;
    }

    public List<CarState> getStates() {
        return this.states;
    }

    public static StateOfCarsList makeCarStateList(List<CarState> states) {
        return new StateOfCarsList(states);
    }
}
