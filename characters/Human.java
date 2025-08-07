package characters;

public class Human extends Gladiator {
    public Human() {
        super("Human", 100, 12, 18);
    }

    @Override
    public int useSpecial() {
        System.out.println("Human uses HEAL! +15 HP");
        health += 15;
        if (health > 100) health = 100;
        return 0;
    }
}
