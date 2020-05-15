package net.nowtryz.epapotage.entity;

import net.nowtryz.epapotage.event.OffLineBavardEvent;
import net.nowtryz.epapotage.event.OnLineBavardEvent;
import net.nowtryz.epapotage.event.PapotageEvent;

import java.util.LinkedList;
import java.util.List;

public class Concierge {
    private final static Concierge singleton = new Concierge();
    private final List<PapotageListener> handlerList = new LinkedList<>();

    public void registerListener(PapotageListener handler) {
        this.handlerList.add(handler);
    }

    public void unregisterListener(PapotageListener handler) {
        this.handlerList.remove(handler);
    }

    public void triggerEvent(PapotageEvent event) {
        handlerList.forEach(h -> h.onPapotageEvent(event));
    }

    public void triggerEvent(OnLineBavardEvent event) {
        handlerList.forEach(h -> h.onJoinEvent(event));
    }

    public void triggerEvent(OffLineBavardEvent event) {
        handlerList.forEach(h -> h.onLeaveEvent(event));
    }

    public List<PapotageListener> getHandlerList() {
        return handlerList;
    }

    public static Concierge getInstance() {
        return Concierge.singleton;
    }
}
