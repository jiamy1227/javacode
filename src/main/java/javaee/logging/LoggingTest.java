package javaee.logging;

import java.util.logging.Logger;

public class LoggingTest {
    private static Logger log = Logger.getGlobal();
    public static void main(String[] args) {

        log.info("1111111111111");
        log.warning("22222222222222");
        log.severe("3333333333333");
        log.fine("3333333333333");
    }
}
