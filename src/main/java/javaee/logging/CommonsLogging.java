package javaee.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLogging {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonsLogging.class);

        log.error("aaaaaaaaaaaaaa");
        log.info("aaaaaaaaaaaaaa");
        log.debug("aaaaaaaaaaaaaa");
    }
}
