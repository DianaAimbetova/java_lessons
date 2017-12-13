public class Sum {


    public final static Number sum(Test<? extends Number> a1, Test<? extends Number>a2){
        return a1.getItem().intValue() + a2.getItem().intValue();
    }


    public static void main(String[] args) {

        Test item1 = new Test();
        item1.setItem(5);
        Test item2 = new Test();
        item2.setItem(2);
        System.out.println(item1.getClass());
        System.out.println(item2.getClass());
        sum(item1, item2);
        System.out.println( sum(item1, item2));

    }
}
