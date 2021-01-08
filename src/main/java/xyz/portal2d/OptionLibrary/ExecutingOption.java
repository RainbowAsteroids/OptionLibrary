package xyz.portal2d.OptionLibrary;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ExecutingOption extends Option {
    private final Runnable action;

    protected ExecutingOption(int id, String label, Runnable action) {
        super(id, label);
        this.action = action;
    }

    public void executingPrompt() {
        ((ExecutingOption) prompt()).getAction().run();
    }

    public Runnable getAction() {
        return action;
    }
}
