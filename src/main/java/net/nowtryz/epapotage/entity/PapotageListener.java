package net.nowtryz.epapotage.entity;

import net.nowtryz.epapotage.event.OffLineBavardEvent;
import net.nowtryz.epapotage.event.OnLineBavardEvent;
import net.nowtryz.epapotage.event.PapotageEvent;

public interface PapotageListener {
    void onPapotageEvent(PapotageEvent event);
    void onJoinEvent(OnLineBavardEvent event);
    void onLeaveEvent(OffLineBavardEvent event);
}
