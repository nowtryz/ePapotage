package net.nowtryz.epapotage.event;

import net.nowtryz.epapotage.Bavard;

import java.text.SimpleDateFormat;

public abstract class Event {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'à' HH'h'mm z");

    protected final long date;
    protected final Bavard source;

    public Event(Bavard source) {
        this(System.currentTimeMillis(), source);
    }

    public Event(long date, Bavard source) {
        this.date = date;
        this.source = source;
    }

    public String getFormattedDate() {
        return formatter.format(date);
    }

    public long getDate() {
        return date;
    }

    public Bavard getSource() {
        return source;
    }
}
