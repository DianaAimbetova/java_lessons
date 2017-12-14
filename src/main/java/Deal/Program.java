package Deal;

import java.util.*;

public class Program {
    private static  int max_products = 0;
    private static  int quantity = 0;
    static Scanner reader = new Scanner(System.in);
    private static List<Product>  products= new ArrayList<Product>();
    private static Collection<Deal> deals = new ArrayList<Deal>();
    static int  tail = 0;
    public static Deal inputDeal() {
        System.out.println("Сколько разных продуктов вы хотите купить?...");
        max_products = reader.nextInt();
        Map<Product,Integer> products = new HashMap<Product,Integer>();
        for (int i = 0; i < max_products; i++) {
            System.out.println("Сколько штук этих продуктов вы хотите купить?...");
            quantity = reader.nextInt();
            System.out.println("Вы хотите купить новый продукт или хотите выбрать из списка? Наберите 0 если хотите создать новый, 1 если хотите выбрать из списка  ");
            int choice = reader.nextInt();
            if(choice==0) {
                products.put(inputProduct(), quantity);
            }else{
                products.put(showAllProducts(), quantity);
            }
        }
        Deal deal = new Deal(inputParty("Seller"),inputParty("Buyer"),products);
        return deal;
    }

    public static Party inputParty(String s){
        System.out.println("-----------------");
        if(s == "Buyer") {
            System.out.print("Введите имя покупателя: ");
            String buyerName = reader.nextLine();
            System.out.print("Введите адрес покупателя: ");
            String addressBuyerName = reader.nextLine();

          //  String keys[] = new String[1];
         //   String values[] = new String[1];
           // for(int i=0; i < values.length; i++){
             //   System.out.print("Введите ключ покупателя: ");
             //   keys[i] = reader.nextLine();
             //   System.out.print("Введите значение покупателя: ");
             //   values[i] = reader.nextLine();
          //  }
            Party buyer = new Party();
            buyer.setName(buyerName);
            buyer.setAddress(addressBuyerName);
           // buyer.setKeys(keys);
           // buyer.setValues(values);
            return buyer;
        } if(s=="Seller") {
            System.out.print("Введите имя продавца: ");
            reader.nextLine();
            String sellerName = reader.nextLine();
            System.out.print("Введите адрес продавца: ");
            String addressSellerName = reader.nextLine();

            String keys[] = new String[1];
            String values[] = new String[1];
           // for(int i=0; i < values.length; i++){
             //   System.out.print("Введите ключ продавца: ");
             //   keys[i] = reader.nextLine();
            //    System.out.print("Введите значение продавца: ");
           //     values[i] = reader.nextLine();
           // }
            Party seller = new Party();
            seller.setName(sellerName);
            seller.setAddress(addressSellerName);
          //  seller.setKeys(keys);
          //  seller.setValues(values);
            return seller;
        }
        return null;
    }

    public static Product inputProduct(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите тип продукта который хотите купить (1 - для фотоаппарата, 2 - для обуви...)");
        int type = reader.nextInt();
        Product p = null;
        if(type == 1) {
                System.out.println("-----------------");
                reader.nextLine();
                System.out.print("Введите название фотоаппарата "  + " ");
                String title = reader.nextLine();
                System.out.print("Введите цену фотоаппарата "  + " ");
                Double price = reader.nextDouble();
               // System.out.print("Введите кол-во фотоаппарата №" +  " ");
               // Integer quantity = reader.nextInt();
                System.out.print("Введите мегапиксели фотоаппарата " +  " ");
                Double megaPx = reader.nextDouble();
                System.out.print("Фотоаппарат цифровой? [y or n] " +  " ");
                reader.nextLine();
                String isDigital = reader.nextLine();
                PhotoProduct product = new PhotoProduct();
                product.setTitle(title);
                product.setPrice(price);
               // product.setQuantity(quantity);
                product.setMegaPx(megaPx);
                if(isDigital.equals("y")) {
                    product.setDigital(true);
                }else if(isDigital.equals("n")){
                    product.setDigital(false);
                }
                p = product;
            products.add(p);
        } else if (type == 2){
                System.out.println("-----------------");
                reader.nextLine();
                System.out.print("Введите название обуви " +  " ");
                String title = reader.nextLine();
                System.out.print("Введите цену обуви " +  " ");
                Double price = reader.nextDouble();
                //System.out.print("Введите кол-во обуви " +  " ");
               // Integer quantity = reader.nextInt();
                System.out.print("Введите размер обуви " +  " ");
                Integer size = reader.nextInt();
                System.out.print("Введите цвет обуви " + " ");
                reader.nextLine();
                String color = reader.nextLine();
                ShoesProduct product = new ShoesProduct();
                product.setTitle(title);
                product.setPrice(price);
               // product.setQuantity(quantity);
                product.setSize(size);
                product.setColor(color);
                p = product;
            products.add(p);
        } else {
            System.err.println("Неизвестный продукт");
            System.exit(-1);
        }

    return p;
    }

    public static void input() {
        System.out.println("Сколько сделок вы хотите заключить? ");
        int maxDeals = reader.nextInt();
        Deal d;
        for (int i = 0; i < maxDeals; i++) {
            d = inputDeal();
        deals.add(d);
        tail++;
    }
    }

    public static void outputProducts(){
        int count = 0;
        for(Deal d : deals) {
            for (Product p:d.getProducts()) {
                //if(p.calcDiscount().equals(0)){
                   // System.out.println(" --- У ВАС К СОЖАЛЕНИЮ НЕТ СКИДКИ :( ---");
                   // count++;
                  //  System.out.println("   Название продукта № " + (count) + "  " + p.getTitle());
                  //  System.out.println("   Цена продукта № " + (count) + "  " + p.getPrice());
                   // System.out.println("   Кол-во продукта № " + (count) + "  " + p.getQuantity());

                //}else {
                    System.out.println(" --- У ВАС СКИДКА НА ЭТОТ ПРОДУКТ :) ---");
                    count++;
                    System.out.println("   Название продукта № " + (count) + "  " + p.getTitle());
                    System.out.println("   Цена продукта № " + (count) + "  " + p.getPrice());
                   // System.out.println("   Кол-во продукта № " + (count) + "  " + p.getQuantity());
                //}
            }
        }
    }

    public static void output(){
        int count = 1;
        for(Deal d : deals){
            System.out.println(" --------ВАША СДЕЛКА----------  ");
            System.out.println("Дата сделки № : " + count + " " + d.getDate());
            System.out.println("Имя покупателя: " + d.getBuyer().getName());
            //System.out.println("Ключи и значения покупателя: " + " ");
//            for (int i = 0; i < d.getBuyer().getKeys().length; i++) {
           //     System.out.println("  " + d.getBuyer().getKeys()[i] + " = "
               //         + d.getBuyer().getValues()[i]);
           // }
            System.out.println("Имя продавца: " + d.getSeller().getName());
          //  System.out.println("Ключи и значения продавца: " + " ");
           // for (int i = 0; i < d.getSeller().getKeys().length; i++) {
              // System.out.println("  " + d.getSeller().getKeys()[i] + " = "
              //          + d.getSeller().getValues()[i]);
           // }
            System.out.println("Продукты: ");
            outputProducts();
            System.out.println("Общая сумма сделки: " + d.getSum());
        }

    }

    public static Product showAllProducts(){
        if(products.isEmpty()){
            System.out.println("Упс! Кажется вы еще не создавали продуктов!");
        }else{
            for (Product p:products) {
                System.out.println(p.getTitle());
                System.out.println(p.getPrice());
                System.out.println(p.getCost(quantity));
                System.out.println("Индексный номер продукта " + products.indexOf(p));
            }
            System.out.println("Введите пожалуйста индексный номер продукта: ");
            int index = reader.nextInt();
            return products.get(index);
        }
        return null;
    }


    public static void main(String[] args) {
        input();
        output();
    }


}
