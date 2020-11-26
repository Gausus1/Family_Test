package IT;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author MJ
 */
public class LogStream extends OutputStream {

    private static LogStream instance = null;

    public static LogStream getInstance() {
        if (instance == null) {
            instance = new LogStream();
        }
        return instance;
    }

    private LogStream() {
        this.info("LOG CREATED");
    }

    public void error(String msg) {
        log("ERROR", msg);
    }

    public void warning(String msg) {
        log("WARNING", msg);
    }

    public void info(String msg) {
        log("INFO", msg);
    }

    private void log(String level, String msg) {
        try {
            write((level + " - " + msg + "\n").getBytes());
        } catch (IOException e) {
            System.err.println("Log not available");
        }
    }

    @Override
    public void write(int b) throws IOException {
        System.out.print((char) b);
    }
}
