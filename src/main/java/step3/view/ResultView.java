package step3.view;


public class ResultView {

    public void renderDrive(int goCount) {
        StringBuffer line = new StringBuffer();
        for(int i = 0; i < goCount; i++){
            line.append("-");
        }
        System.out.println(line.toString());
    }

}
