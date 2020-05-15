package net.nowtryz.epapotage.event;

import net.nowtryz.epapotage.entity.Bavard;
import net.nowtryz.epapotage.Themes;

import java.util.LinkedList;
import java.util.List;

public class PapotageEvent extends Event {
    private final String text;
    private final List<Themes> categories;


    public PapotageEvent(Bavard source, String text) {
        super(source);
        this.text = text;
        this.categories = new LinkedList<>();
        this.categories.add(Themes.DEFAULT);
    }

    public PapotageEvent(Bavard source, String text, List<Themes> categories) {
        super(source);
        this.text = text;
        this.categories = categories;
    }

    public PapotageEvent(long date, Bavard source, String text, List<Themes> categories) {
        super(date, source);
        this.text = text;
        this.categories = categories;
    }

    public String getText() {
        return text;
    }

    public List<Themes> getCategories() {
        return categories;
    }
}
