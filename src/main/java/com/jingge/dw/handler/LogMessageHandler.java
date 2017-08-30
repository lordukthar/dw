package com.jingge.dw.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.math.Ordering;

/**
 * Created by jing.ge on 22.01.2015.
 */
public class LogMessageHandler implements MessageHandler {

    Logger LOG = LoggerFactory.getLogger(LogMessageHandler.class);

    @Override
    public void start() {
        LOG.info(" Handler is started");
    }

    @Override
    public void stop() {
        LOG.info("Handler is stopped");
    }

    @Override
    public void dispose(byte[] message) {

        String jalla = new String(message);


        LOG.info(jalla);
        LOG.info(message + " is diposed.");
    }
}
