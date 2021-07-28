package racing;

public class OutputView {

    public void startPrintResult() {
        System.out.println("실행결과");
    }

    public void printResult(CarsDTO carsDTO) {
        for (int position : carsDTO.getCars()) {
            System.out.println(convertToFormat(position));
        }
        System.out.println();
    }

    private String convertToFormat(int position) {
        return new String(new char[position]).replace("\0", "-");
    }

}
