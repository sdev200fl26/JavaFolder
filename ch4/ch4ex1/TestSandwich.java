
// Bill Ruben
// p.156 ex.1
import java.util.Scanner;

public class TestSandwich {
    public static void main(String[] args) {
        Sandwich firstSandwich = new Sandwich();
        firstSandwich = getData(firstSandwich);
        System.out.println("You ordered a: " + firstSandwich.getIngredient() +
                " on " + firstSandwich.getBreadType() +
                " and the cost of the sandwich is $" + firstSandwich.getPrice());
    }

    public static Sandwich getData(Sandwich service) {
        String ingredient;
        String breadType;
        double price;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the ingredient >> ");
        ingredient = keyboard.nextLine();
        System.out.print("Enter the name of the bread type >> ");
        breadType = keyboard.nextLine();
        System.out.print("Enter the price of the sandwich >> $");
        price = keyboard.nextDouble();
        keyboard.nextLine();
        service.setIngredient(ingredient);
        service.setBreadType(breadType);
        service.setPrice(price);
        return service;
    }
}
