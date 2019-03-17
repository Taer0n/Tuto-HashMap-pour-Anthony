package fr.taeron;

import fr.taeron.objects.Human;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Loïc on 17/03/2019
 **/
public class Tuto {

    private HashMap<Integer, Human> humans;

    public static void main(String[] args) {
        new Tuto();
    }

    public Tuto() {

        humans = new HashMap<>();

        humans.put(1, new Human("Loïc"));
        humans.put(2, new Human("Anthony"));
        humans.put(420, new Human("Jean"));

        System.out.println("Humains enregistrés dans la HashMap: ");

        humans.values().stream().forEach(human -> System.out.println("- " + human.getName()));

        System.out.println("Keys: " + humans.keySet());

        System.out.println("Humain enregistré sous l'id 2: " + getHuman(2).getName());

        System.out.println("Humain enregistré sous l'id 254: " + getHuman(254).getName());

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if(!isInt(input)){
                System.out.println("Merci d'entrer un nombre valide.");
            } else {
                System.out.println("Humain enregistré sous l'id " + input + ": " + getHuman(Integer.parseInt(input)).getName());
            }
        }
    }

    private Human getHuman(int id) {
        return humans.getOrDefault(id, new Human("Aucun"));  //getOrDefault: récupère la valeur de la clé ou une valeur par défaut si la map ne contient pas cette clé
    }

    private boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
