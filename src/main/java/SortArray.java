import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        //размер массива установливает пользователь
        int size = reader.nextInt();
        int arr[] = new int[size];
        //содержимое массива указывает пользователь
        System.out.print("Введите содержимое массива: ");
        for(int i = 0; i < arr.length; i++){
            int number = reader.nextInt();
            arr[i] = number;
        }
        sort(arr);
    }


    public static void sort(int arr[]){
        System.out.println("Отсортированный массив: ");
        //позиция нахождения минимального значения
        int min = 0;
        //счетчик временный
        int temp = 0;
        //бежит по массиву от начала
        for(int i = 0; i < arr.length; i++){
            //изначально минимальное значение находится в первой позиции
            min = i;
        //бежит по следующему значению массива
            for(int j = i+1; j < arr.length; j++){
                //если это значение меньше чем первое
            if(arr[j]<arr[min]){
                //теперь позиция минимума становится это
                min = j;
            }
        }
            //если минимум уже находится на первой позиций
            if(arr[min] == arr[i]){
                //остается на месте
            }
            //поменять местами
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            System.out.print(arr[i] + " ");
        }


    }
}
