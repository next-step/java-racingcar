package fifthrefactoring.domain;

public class Moving {
    private Strategy strategy;

    public boolean move(){
        return strategy.move();
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
}


