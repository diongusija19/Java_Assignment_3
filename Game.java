import characters.*;
import arena.*;
import utils.Colors;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            System.out.println(Colors.CYAN + "\n--- GLADIATOR ARENA ---" + Colors.RESET);
            System.out.println("Choose your Gladiator:");
            System.out.println("1. Human");
            System.out.println("2. Elf");
            System.out.println("3. Orc");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            Gladiator player;
            switch (choice) {
                case 1: player = new Human(); break;
                case 2: player = new Elf(); break;
                case 3: player = new Orc(); break;
                default: player = new Human(); break;
            }

            Gladiator enemy = new Orc();
            Arena arena = (Math.random() < 0.5) ? new Desert() : new StormySky();

            System.out.println(Colors.YELLOW + "\nArena: " + arena.getName() + Colors.RESET);

            int turn = 1;
            final int MAX_TURNS = 15;

            while (player.isAlive() && enemy.isAlive() && turn <= MAX_TURNS) {
                System.out.printf("\n%s-- Turn %d --%s%n", Colors.CYAN, turn, Colors.RESET);
                arena.affect(player);
                arena.affect(enemy);

                System.out.println("Your stats:");
                player.printStats();
                System.out.println("Enemy stats:");
                enemy.printStats();

                System.out.print("Attack or Special? (a/s): ");
                String move = scanner.next();
                int damage;

                if (move.equalsIgnoreCase("s") && player.canUseSpecial(turn)) {
                    damage = player.useSpecial();
                    player.lastSpecialTurn = turn;
                } else {
                    damage = player.basicAttack();
                    System.out.println("You attack the enemy for " + damage + " damage.");
                }
                enemy.takeDamage(damage);

                if (!enemy.isAlive()) break;

                int enemyDamage = enemy.basicAttack();
                player.takeDamage(enemyDamage);
                System.out.println("Enemy attacks you for " + enemyDamage + " damage.");

                turn++;
            }

            System.out.println(Colors.RED + "\n--- GAME OVER ---" + Colors.RESET);
            if (player.isAlive() && !enemy.isAlive()) {
                System.out.println(Colors.GREEN + "You are victorious!" + Colors.RESET);
            } else if (!player.isAlive() && enemy.isAlive()) {
                System.out.println(Colors.RED + "You were defeated." + Colors.RESET);
            } else {
                if (player.getHealth() > enemy.getHealth()) {
                    System.out.println(Colors.GREEN + "Time's up, but you had more health. You win!" + Colors.RESET);
                } else if (enemy.getHealth() > player.getHealth()) {
                    System.out.println(Colors.RED + "Time's up. Enemy had more health. You lose." + Colors.RESET);
                } else {
                    System.out.println("It's a draw!");
                }
            }

            System.out.print("\nPlay again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
