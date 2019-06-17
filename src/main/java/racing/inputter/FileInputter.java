package racing.inputter;

import racing.exception.ScanException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.stream.Stream;

/**
 * 요구사항에는 벗어나지만 인터페이스 학습용으로 작성
 */
public class FileInputter implements Inputter {

    private final String fileName;

    public FileInputter(String fileName) {this.fileName = fileName;}

    @Override
    public int inputIntValue() {

        try {
            Path path = Paths.get(ClassLoader.getSystemResource(fileName).toURI());
            Stream<String> lines = Files.lines(path);
            return lines.map(Integer::valueOf).findFirst().orElseThrow(() -> new ScanException("입력도중 에러가 발생했습니다"));
        } catch (URISyntaxException | IOException e) {
            throw new ScanException(e);
        }
    }
}
