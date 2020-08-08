package step4.dto;

public class Competition {

    private int paticipate;
    private int rount;

    private Competition(int paticipate, int rount) {
        this.paticipate = paticipate;
        this.rount = rount;
    }

    public static Competition create(int paticipate, int rount) {
        return new Competition(paticipate, rount);
    }

    public int getPaticipate() {
        return paticipate;
    }

    public int getRount() {
        return rount;
    }
}
