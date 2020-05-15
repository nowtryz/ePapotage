package net.nowtryz.epapotage.event;

import net.nowtryz.epapotage.Bavard;

public class PapotageEvent extends Event {
    private String text;

    public PapotageEvent(Bavard source) {
        super(source);
    }

    public PapotageEvent(long date, Bavard source) {
        super(date, source);
    }
}
