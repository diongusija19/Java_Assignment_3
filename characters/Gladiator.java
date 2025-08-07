package characters;

public abstract class Gladiator {
    protected String name;
    protected int health;
    protected int minDamage;
    protected int maxDamage;
    public int lastSpecialTurn = -5;

    public Gladiator(String name, int health, int minDamage, int maxDamage) {
        this.name = name;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0) health = 0;
    }

    public void printStats() {
        System.out.printf("%s - HP: %d, DMG: %d-%d%n", name, health, minDamage, maxDamage);
    }

    public int basicAttack() {
        return (int)(Math.random() * (maxDamage - minDamage + 1)) + minDamage;
    }

    public boolean canUseSpecial(int turn) {
        return (turn - lastSpecialTurn) >= 5;
    }

    public abstract int useSpecial();

    public String getName() {
        return name;
    }
}
