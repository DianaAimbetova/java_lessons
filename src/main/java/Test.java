import java.util.*;

public class Test<T extends Number> extends Sum {
    private T item;

List l = new LinkedList<Integer>();
List a = new ArrayList();
HashSet h = new HashSet();
TreeSet t = new TreeSet();
HashMap hm = new HashMap();
TreeMap tm = new TreeMap();
Queue q = new PriorityQueue();

    public T getItem() {

        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }



    public static void main(String[] args) {
        List<Integer> l = new LinkedList<Integer>();
        HashSet<Integer> h = new HashSet();
        h.add(7);
        h.add(7);
        h.add(8);
        for (Integer i:h) {
            if(i==7) {
                l.add(i);
            }


        }

            l.removeAll(l);
        System.out.println(l.size());



        l.add(5);
        l.add(2);
        l.add(3);
        for(Iterator<Integer> iter = l.iterator(); iter.hasNext();){
                Integer elem = iter.next();
                System.out.println(elem);
        }

        Iterator<Integer> iter = l.iterator();
        while(iter.hasNext()){
            Integer elem = iter.next();
            System.out.println(elem);
        }


        Queue q = new PriorityQueue();
        q.add(1);
        q.add(5);
        q.add(10);
        for (Object o:q) {
            System.out.println(o.toString());
        }
        System.out.println("---" + q.element().toString());


        System.out.println("---MAPS---");
        HashMap<Integer,String> hm = new HashMap();
            hm.put(5, "five");
            hm.put(6, "six");
            hm.put(7, "seven");

        Set<Map.Entry<Integer,String>> entry = hm.entrySet();
            for(Map.Entry<Integer,String> ent : entry){
                System.out.println(ent.getKey() + " - " + ent.getValue());

            }

    }

}
