package Deal;

import java.util.*;

public class Deal {
    private Date date;
    private Party buyer;
    private Party seller;
    private Map<Product, Integer> products;
   // private int quantity;

    public Deal(Party seller, Party buyer, Map<Product, Integer> products){
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

    public Collection<Product> getProducts() {
        Collection<Product> result = new ArrayList<Product>();
        Set<Map.Entry<Product,Integer>> entries = products.entrySet();
        for(Map.Entry<Product,Integer> entry: entries){
            result.add(entry.getKey());
        }
        return result;
    }

    public double getSum(){
        double result = 0.0;
        Set<Map.Entry<Product,Integer>> entries = products.entrySet();
        for(Map.Entry<Product,Integer> entry: entries){
            result+=entry.getKey().getCost(entry.getValue());
        }
        return result;
    }



}
