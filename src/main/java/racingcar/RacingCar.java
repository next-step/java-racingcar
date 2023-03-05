package racingcar;

public class RacingCar {
    private String name;
    private int runCount = 0;

    public RacingCar(String name){
        this.name = name;
    }

    public void run(){
        if(RacingRandom.randomizeTenBegger() >= 4){
            this.runCount++;
        }
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(name.toString());
        sb.append(" : ");
        int startCount = 0;
        while( startCount < runCount){
            sb.append('-');
            startCount++;
        }
        System.out.println(sb.toString());
    }
}
