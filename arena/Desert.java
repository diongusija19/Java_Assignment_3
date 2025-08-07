package arena;

import characters.Gladiator;

public class Desert extends Arena {
    public Desert() {
        super("Desert");
    }

    @Override
    public void affect(Gladiator g) {
        g.takeDamage(3);
        System.out.println("🔥 Desert heat drains 3 HP from " + g.getName());
    }
}
