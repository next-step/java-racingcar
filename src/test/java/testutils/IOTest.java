package testutils;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class IOTest {
  protected void setInputStream(byte[] inputBytes) {
    System.setIn(new ByteArrayInputStream(inputBytes));
  }

  protected void setOutputStream(OutputStream outputStream) {
    System.setOut(new PrintStream(outputStream));
  }
}
