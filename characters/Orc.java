package characters;

public class Orc extends Gladiator {
    public Orc() {
        super("Orc", 120, 8, 12);
    }

    @Override
    public int useSpecial() {
        System.out.println("Orc uses BERSERK! Deals fixed 25 damage!");
        return 25;
    }
}
