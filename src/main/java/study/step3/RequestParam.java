package study.step3;

public class RequestParam {
    private int carCount;
    private int tryCount;

    public RequestParam(String carParam, String tryParam){
        this(Integer.parseInt(carParam), Integer.parseInt(tryParam));
    }

    RequestParam(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

//    private int parseStringToInt(String param){
////        param.
//        return Integer.parseInt(param);
//    }

//    public String minus;
//
//    Car(int moveSpace, String minus) {
//        this.moveSpace = moveSpace;
//        this.minus = minus;
//    }

}
