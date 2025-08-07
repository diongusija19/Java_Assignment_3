package arena;

import characters.Gladiator;

public class StormySky extends Arena {
    public StormySky() {
        super("Stormy Sky");
    }

    @Override
    public void affect(Gladiator g) {
        if (Math.random() < 0.3) {
            g.takeDamage(5);
            System.out.println("⚡ Lightning strikes " + g.getName() + " for 5 damage!");
        }
    }
}
