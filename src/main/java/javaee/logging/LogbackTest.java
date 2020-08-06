package javaee.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogbackTest.class);

        logger.info("info");
        logger.warn("warn");
        logger.debug("debug");
        logger.error("error");
    }
}
