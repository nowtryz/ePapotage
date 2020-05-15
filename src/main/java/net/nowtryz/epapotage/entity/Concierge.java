package net.nowtryz.epapotage.entity;

import net.nowtryz.epapotage.event.OffLineBavardEvent;
import net.nowtryz.epapotage.event.OnLineBavardEvent;
import net.nowtryz.epapotage.event.PapotageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StringFormatterMessageFactory;

import java.util.LinkedList;
import java.util.List;

public class Concierge {
    private final static Logger logger = LogManager.getLogger();
    private final static Concierge singleton = new Concierge();
    private final List<PapotageListener> handlerList = new LinkedList<>();

    public Concierge() {
        logger.info("Registered Concierge");
    }

    public void registerListener(PapotageListener handler) {
        this.handlerList.add(handler);
    }

    public void unregisterListener(PapotageListener handler) {
        this.handlerList.remove(handler);
    }

    public void triggerEvent(PapotageEvent event) {
        handlerList.forEach(h -> h.onPapotageEvent(event));
        logger.debug("Received from {}: {}", event.getSource().getUsername(), event.getText());
    }

    public void triggerEvent(OnLineBavardEvent event) {
        handlerList.forEach(h -> h.onJoinEvent(event));
        logger.debug("{} joined the tchat", event.getSource());
    }

    public void triggerEvent(OffLineBavardEvent event) {
        handlerList.forEach(h -> h.onLeaveEvent(event));
        logger.debug("{} left the tchat", event.getSource());
    }

    public List<PapotageListener> getHandlerList() {
        return handlerList;
    }

    public static Concierge getInstance() {
        return Concierge.singleton;
    }
}
