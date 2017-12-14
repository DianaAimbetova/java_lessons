package Deal;

import java.util.Scanner;

public class Program {
    private static final int MAX_PRODUCTS = 1;
    private static final int MAX_DEALS = 1;
    static Scanner reader = new Scanner(System.in);
    private static Deal[] deals = new Deal[MAX_DEALS];
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
            System.out.print("Введите адрес покупателя: ");
            String addressBuyerName = reader.nextLine();

            String keys[] = new String[1];
            String values[] = new String[1];
            for(int i=0; i < values.length; i++){
                System.out.print("Введите ключ покупателя: ");
                keys[i] = reader.nextLine();
                System.out.print("Введите значение покупателя: ");
                values[i] = reader.nextLine();
            }
            Party buyer = new Party();
            buyer.setName(buyerName);
            buyer.setAddress(addressBuyerName);
            buyer.setKeys(keys);
            buyer.setValues(values);
            return buyer;
        } if(s=="Seller") {
            System.out.print("Введите имя продавца: ");
            String sellerName = reader.nextLine();
            System.out.print("Введите адрес продавца: ");
            String addressSellerName = reader.nextLine();

            String keys[] = new String[1];
            String values[] = new String[1];
            for(int i=0; i < values.length; i++){
                System.out.print("Введите ключ продавца: ");
                keys[i] = reader.nextLine();
                System.out.print("Введите значение продавца: ");
                values[i] = reader.nextLine();
            }
            Party seller = new Party();
            seller.setName(sellerName);
            seller.setAddress(addressSellerName);
            seller.setKeys(keys);
            seller.setValues(values);
            return seller;
        }
        return null;
    }

    public static Product[] inputProduct(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите тип продукта который хотите купить (1 - для фотоаппарата, 2 - для обуви...)");
        int type = reader.nextInt();
        Product[] products = null;
        if(type == 1) {
            products = new PhotoProduct[MAX_PRODUCTS];
            int count = 0;
            for (int i = 0; i < products.length; i++) {
                System.out.println("-----------------");
                reader.nextLine();
                System.out.print("Введите название фотоаппарата №" + (count + 1) + " ");
                String title = reader.nextLine();
                System.out.print("Введите цену фотоаппарата №" + (count + 1) + " ");
                Double price = reader.nextDouble();
                System.out.print("Введите кол-во фотоаппарата №" + (count + 1) + " ");
                Integer quantity = reader.nextInt();
                System.out.print("Введите мегапиксели фотоаппарата №" + (count + 1) + " ");
                Double megaPx = reader.nextDouble();
                System.out.print("Фотоаппарат цифровой? y or n " + (count + 1) + " ");
                reader.nextLine();
                String isDigital = reader.nextLine();
                PhotoProduct product = new PhotoProduct();
                product.setTitle(title);
                product.setPrice(price);
                product.setQuantity(quantity);
                product.setMegaPx(megaPx);
                if(isDigital.equals("y")) {
                    product.setDigital(true);
                }else if(isDigital.equals("n")){
                    product.setDigital(false);
                }
                products[count] = product;
                count++;
            }
            return products;
        } if(type == 2){
            products = new ShoesProduct[MAX_PRODUCTS];
            int count = 0;
            for (int i = 0; i < products.length; i++) {
                System.out.println("-----------------");
                reader.nextLine();
                System.out.print("Введите название обуви №" + (count + 1) + " ");
                String title = reader.nextLine();
                System.out.print("Введите цену обуви №" + (count + 1) + " ");
                Double price = reader.nextDouble();
                System.out.print("Введите кол-во обуви №" + (count + 1) + " ");
                Integer quantity = reader.nextInt();
                System.out.print("Введите размер обуви №" + (count + 1) + " ");
                Integer size = reader.nextInt();
                System.out.print("Введите цвет обуви №" + (count + 1) + " ");
                reader.nextLine();
                String color = reader.nextLine();
                ShoesProduct product = new ShoesProduct();
                product.setTitle(title);
                product.setPrice(price);
                product.setQuantity(quantity);
                product.setSize(size);
                product.setColor(color);
                products[count] = product;
                count++;
            }
            return products;
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
                if(p.calcDiscount().equals(0)){
                    System.out.println(" --- У ВАС К СОЖАЛЕНИЮ НЕТ СКИДКИ :( ---");
                    count++;
                    System.out.println("   Название продукта № " + (count) + "  " + p.getTitle());
                    System.out.println("   Цена продукта № " + (count) + "  " + p.getPrice());
                    System.out.println("   Кол-во продукта № " + (count) + "  " + p.getQuantity());

                }else {
                    System.out.println(" --- У ВАС СКИДКА НА ЭТОТ ПРОДУКТ :) ---");
                    count++;
                    System.out.println("   Название продукта № " + (count) + "  " + p.getTitle());
                    System.out.println("   Цена продукта № " + (count) + "  " + p.getPrice());
                    System.out.println("   Кол-во продукта № " + (count) + "  " + p.getQuantity());
                }
            }
        }
    }

    public static void output(){
        int count = 1;
        for(Deal d : deals){
            System.out.println(" --------ВАША СДЕЛКА----------  ");
            System.out.println("Дата сделки № : " + count + " " + d.getDate());
            System.out.println("Имя покупателя: " + d.getBuyer().getName());
            System.out.println("Ключи и значения покупателя: " + " ");
            for (int i = 0; i < d.getBuyer().getKeys().length; i++) {
                System.out.println("  " + d.getBuyer().getKeys()[i] + " = "
                        + d.getBuyer().getValues()[i]);
            }
            System.out.println("Имя продавца: " + d.getSeller().getName());
            System.out.println("Ключи и значения продавца: " + " ");
            for (int i = 0; i < d.getSeller().getKeys().length; i++) {
                System.out.println("  " + d.getSeller().getKeys()[i] + " = "
                        + d.getSeller().getValues()[i]);
            }
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
