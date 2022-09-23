package racingCar.domain;

public class Car {

    private int distance;

    private final String GRAPH_BAR = "-";

    public Car() {
        this.distance = 0;
    }

    public void race() {
        if(isRun()){
            this.distance += 1;
        }
    }

    public String showDistance(){
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            graph.append(GRAPH_BAR);
        }
        return graph.toString();
    }

    private boolean isRun() {
        int random = (int) ( Math.random() * 10 );
        return random > 3 ;
    }

}
