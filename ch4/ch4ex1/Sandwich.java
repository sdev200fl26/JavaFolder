// Bill Ruben
// p.156 ex. 1
public class Sandwich {
    private String ingredient;
    private String breadType;
    private double price;
    public void setIngredient(String ing) {
        ingredient = ing;
    }

     public void setBreadType(String bt) {
        breadType = bt;
    }
    public void setPrice(double prc) {
        price = prc;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getBreadType() {
        return breadType;
    }

    public double getPrice() {
        return price;
    }
}