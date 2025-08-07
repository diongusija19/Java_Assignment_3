package arena;

import characters.Gladiator;

public abstract class Arena {
    protected String name;

    public Arena(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void affect(Gladiator g);
}
