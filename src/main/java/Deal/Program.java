package Deal;

import java.util.Scanner;

public class Program {
    static Scanner reader = new Scanner(System.in);
    private static Deal[] deals = new Deal[3];
    static int  tail = 0;
    public static Deal inputDeal() {

        Deal deal = new Deal(inputParty("Seller"),inputParty("Buyer"),inputProduct());
        return deal;
    }

    public static Party inputParty(String s){
        System.out.println("-----------------");
        if(s == "Buyer") {
            System.out.print("Введите имя покупателя: ");
            String buyerName = reader.nextLine();
            Party buyer = new Party();
            buyer.setName(buyerName);
            return buyer;
        } if(s=="Seller") {
            System.out.print("Введите имя продавца: ");
            String sellerName = reader.nextLine();
            Party seller = new Party();
            seller.setName(sellerName);
            return seller;
        }
        return null;
    }

    public static Product[] inputProduct(){
        Product[] products = new Product[3];
         Scanner reader = new Scanner(System.in);
        int count = 0;
        for(int i = 0; i < 3; i++) {
            System.out.println("-----------------");
            reader.nextLine();
            System.out.print("Введите название продукта №" + (count+1) + " ");
            String title = reader.nextLine();
            System.out.print("Введите цену продукта №" + (count+1) + " " );
            Double price = reader.nextDouble();
            System.out.print("Введите кол-во продукта №" + (count+1) + " " );
            Integer quantity = reader.nextInt();
            Product product = new Product();
            product.setTitle(title);
            product.setPrice(price);
            product.setQuantity(quantity);
            products[count] = product;
            count++;
        }
        return products;
    }

    public static void input() {
        Deal d;
        for (int i = 0; i < deals.length; i++) {
            d = inputDeal();
        deals[tail] = d;
        tail++;
    }
    }

    public static void outputProducts(){
        int count = 0;
        for(Deal d : deals) {
            for (Product p:d.getProducts()) {
                count++;
                System.out.println("   Название продукта № " + (count) + "  " + p.getTitle());
                System.out.println("   Цена продукта № " + (count) + "  " + p.getPrice());
                System.out.println("   Кол-во продукта № " + (count) + "  " + p.getQuantity());
            }
        }
    }

    public static void output(){
        int count = 1;
        for(Deal d : deals){
            System.out.println("Дата сделки № : " + count + " " + d.getDate());
            System.out.println("Имя покупателя: " + d.getBuyer().getName());
            System.out.println("Имя продавца: " + d.getSeller().getName());
            System.out.println("Продукты: ");
            outputProducts();
            System.out.println("Общая сумма сделки: " + d.getSum());
        }

    }

    public static void main(String[] args) {
        input();
        output();
    }
}
