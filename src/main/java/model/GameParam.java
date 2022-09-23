package model;

public class GameParam {

    private int carNum;

    private int tryNum;

    public static class GameParamBuilder {
        private int carNum;

        private int tryNum;

        public GameParamBuilder carNum(int carNum){
            this.carNum = carNum;
            return this;
        }

        public GameParamBuilder tryNum(int tryNum){
            this.tryNum = tryNum;
            return this;
        }

        public GameParam build(){
            return new GameParam(this);
        }
    }

    private GameParam(GameParamBuilder builder) {
        this.carNum = builder.carNum;
        this.tryNum = builder.tryNum;
    }

    public int getCarNum() {
        return carNum;
    }

    public int getTryNum() {
        return tryNum;
    }
}