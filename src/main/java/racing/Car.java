package racing;

public class Car {
    private static final char sign = '-';
    private int allMeter = 0;

    public int run(int meter){
        allMeter = allMeter + meter;
        for(int i = 0 ; i < allMeter ; i++){
            System.out.print(sign);
        }
        stopRunning();
        return allMeter;
    }

    private void stopRunning(){
        System.out.println();
    }

    public int totalMeter() {
        return this.allMeter;
    }
}
