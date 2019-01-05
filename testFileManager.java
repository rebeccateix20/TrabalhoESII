import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class testFileManager {


    /*
    @Test
    public void testWrite() throws IOException {
        FileManager fm = new FileManager();
        String file = fm.Reader("ola.txt");
        String  newStr= file.replaceAll("[,.!?\\-_\n,\\s]","");
        fm.Writer(newStr, "newfile.txt");
        assertEquals("ola123", newStr);

    }
*/
    @Test
    public void testWrite() throws IOException {
        FileManager fm = new FileManager();
        String file = fm.Reader("ola.txt");
        String  newStr= file.replaceAll("[,.!?\\-_\n,\\s]","");
        assertEquals(true, fm.Writer(newStr, "newfile.txt"));
    }

    @Test
    public void testFileNotFound() throws IOException {
        FileManager fm = new FileManager();
        //String file = fm.Reader("powpow.txt");
        //String  newStr= file.replaceAll("[,.!?\\-_\n,\\s]","");
        assertEquals(null, fm.Reader("powpow.txt"));
    }

}
