import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {

    FileOutputStream  output;

    public WriteFile() throws FileNotFoundException {
        output = new FileOutputStream("src/_log.txt" );
        // позже нужно создать заголовки в логах чтобы QLIK BI размечал столбцы
    }

    void writeFileLogTXT(String bufferLine) throws IOException {
        output.write(bufferLine.getBytes());
    }

    void closeFileLogTXT() throws IOException {
        output.close();
    }
}

