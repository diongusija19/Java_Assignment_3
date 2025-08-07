package characters;

public class Elf extends Gladiator {
    public Elf() {
        super("Elf", 80, 10, 15);
    }

    @Override
    public int useSpecial() {
        int damage = (int)(Math.random() * (maxDamage - minDamage + 1)) + minDamage;
        int total = Math.min(damage * 2, 30);
        System.out.println("Elf uses DOUBLE STRIKE! Total damage: " + total);
        return total;
    }
}
