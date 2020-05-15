package net.nowtryz.epapotage.event;

import net.nowtryz.epapotage.entity.Bavard;

public class OffLineBavardEvent extends Event {
    public OffLineBavardEvent(Bavard source) {
        super(source);
    }

    public OffLineBavardEvent(long date, Bavard source) {
        super(date, source);
    }
}
