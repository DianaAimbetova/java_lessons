package Deal;

import java.util.Date;

public class Deal {
    private Date date;
    private Party buyer;
    private Party seller;
    private Product[] products;

    public Deal(Party seller, Party buyer, Product[] products){
        this.seller = seller;
        this.buyer = buyer;
        this.products = products;
        date = new Date();

    }

    public Date getDate() {
        return date;
    }

    public Party getBuyer() {
        return buyer;
    }

    public Party getSeller() {
        return seller;
    }

    public Product[] getProducts() {
        return products;
    }

    public double getSum(){
        double result = 0.0;
        for(Product i : products){
            result+=i.getCost();
        }
        return result;
    }
}
