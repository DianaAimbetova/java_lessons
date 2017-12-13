package Deal;

public abstract class Product {
    public static final int DISCOUNT_PERCENT = 10;
    private String title;
    private double price;
    private int quantity;

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        if (calcDiscount() == 0){
            return quantity * price;
    }
            return quantity*(100-((price* DISCOUNT_PERCENT)/100));

}
    protected int calcDiscount(){
        if(quantity>=10){
            return DISCOUNT_PERCENT;
        }
        return 0;
    }
}
