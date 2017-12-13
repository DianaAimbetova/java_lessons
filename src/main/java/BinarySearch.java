public class BinarySearch {

    public static void main(String[] args) {
        char arr[] = {'a','d','k','m','n','o','q'};
        binarySearch(arr,'q');

    }

    public static void binarySearch(char[] arr, char a) {
        int size = arr.length;//7
        int high = size - 1;//6
        int low = 0;//0 4 6
        int index =0;//0
        for(int i = low; i <= high; i++){
            int middle = (low+high)/2;//3 5 6
            if(arr[middle] == a){
                index = middle;//yes
            }
            if(arr[middle]<a){
                low = middle + 1;//4 6
            }
            if(arr[middle]>a){
                high = middle - 1;

            }
        }
        System.out.println(index);
    }
}

