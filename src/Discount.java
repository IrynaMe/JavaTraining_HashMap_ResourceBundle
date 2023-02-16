
public class Discount {
    private int discountRate;
    private float oldPrice, newPrice;

    public Discount(int discountRate, float oldPrice, float newPrice) {
        this.discountRate = discountRate;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    @Override
    public String toString() {
        return "discount: " + discountRate + "%" +
                ", old price: " + String.format("%.2f", oldPrice) +
                "€, new price: " + String.format("%.2f", newPrice) + "€";
    }
}



