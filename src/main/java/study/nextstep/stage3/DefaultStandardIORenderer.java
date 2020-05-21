package study.nextstep.stage3;

public class DefaultStandardIORenderer implements Renderer {
    private static final String CAR_PATH_CHARACTER = "-";

    @Override
    public void render(GameStatus status) {
        for(int i = 0; i < status.size(); i ++){
            System.out.println(CAR_PATH_CHARACTER.repeat(status.renderCarPosition(i)));
        }
        System.out.println();
    }

    @Override
    public void renderFirstStatus(GameStatus status) {
        System.out.println("실행 결과");
        render(status);
    }
}