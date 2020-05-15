package net.nowtryz.epapotage.event;

import net.nowtryz.epapotage.entity.Bavard;

public class OnLineBavardEvent extends Event {
    public OnLineBavardEvent(Bavard source) {
        super(source);
    }

    public OnLineBavardEvent(long date, Bavard source) {
        super(date, source);
    }
}
