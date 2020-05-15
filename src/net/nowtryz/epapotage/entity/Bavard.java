package net.nowtryz.epapotage.entity;

import net.nowtryz.epapotage.event.OffLineBavardEvent;
import net.nowtryz.epapotage.event.OnLineBavardEvent;
import net.nowtryz.epapotage.event.PapotageEvent;

public class Bavard implements PapotageListener {
    private String username;

    public Bavard(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void connect() {
        Concierge.getInstance().registerListener(this);
        Concierge.getInstance().triggerEvent(new OnLineBavardEvent(this));
    }

    public void disconnect() {
        Concierge.getInstance().triggerEvent(new OffLineBavardEvent(this));
        Concierge.getInstance().unregisterListener(this);
    }

    public void dispatchMessage(String message) {
        Concierge.getInstance().triggerEvent(new PapotageEvent(this, message));
    }

    @Override
    public void onPapotageEvent(PapotageEvent event) {

    }

    @Override
    public void onJoinEvent(OnLineBavardEvent event) {

    }

    @Override
    public void onLeaveEvent(OffLineBavardEvent event) {

    }
}
