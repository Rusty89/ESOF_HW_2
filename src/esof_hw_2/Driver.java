package esof_hw_2;

/**
 *
 * authors: Rusty Clayton, Nick Hager ESOF 322 HW 2 Date: 9/12/2018 Description:
 *
 */
import java.util.Scanner;

/////////////////////////////////////////////////////
abstract class Program implements ISortBehavior {

    ISortBehavior sb;

    public Program() {
        sb = new BubbleSort();
    }

    public void changeMethod(ISortBehavior userChoice) {
        sb = userChoice;
    }

}
///////////////////////////////////////////////////////

class Matematica extends Program {

    ISortBehavior sb;

    public Matematica() {
        sb = new InsertionSort();
        System.out.println("\nMatematica Selected:\ndefault sort method is Insertion Sort\n");

    }

    public void mathSort(int[] inArray) {
        sb.mathSort(inArray);
    }

    public void changeMethod(ISortBehavior userChoice) {
        sb = userChoice;
    }
}
//////////////////////////////////////////////////////////

class MTool extends Program {

    ISortBehavior sb;

    public MTool() {
        sb = new MergeSort();
        System.out.println("\nMTool selected:\ndefault sort method is Merge Sort\n");
    }

    public void mathSort(int[] inArray) {
        sb.mathSort(inArray);
    }

    public void changeMethod(ISortBehavior userChoice) {
        sb = userChoice;
    }
}
////////////////////////////////////////////////////////////

class MyMath extends Program {

    ISortBehavior sb;

    public MyMath() {
        sb = new BubbleSort();
        System.out.println("\nMyMath Selected:\ndefault sort method is Bubble Sort\n");
    }

    public void mathSort(int[] inArray) {
        sb.mathSort(inArray);
    }

    public void changeMethod(ISortBehavior userChoice) {
        sb = userChoice;
    }
}

///////////////////////////////////////////////////////////
interface ISortBehavior {

    public void mathSort(int[] inArray);

}
///////////////////////////////////////////////////////////

class MergeSort implements ISortBehavior {

    public MergeSort() {
        System.out.println("Merge Sort");
    }

    public void mathSort(int[] inArray) {
        sort(inArray,0,inArray.length-1);
    }
    
    
    //functions merge and sort from Geeks for Geeks 
    
    //url https://www.geeksforgeeks.org/merge-sort/
    
    void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 

}
//////////////////////////////////////////////////////////

class InsertionSort implements ISortBehavior {

    public InsertionSort() {

    }

    public void mathSort(int[] inArray) {
        int i = 1;
        while (i < inArray.length) {
            int j = i;

            while (j > 0 && inArray[j - 1] > inArray[j]) {
                int temp = inArray[j];
                inArray[j] = inArray[j - 1];
                inArray[j - 1] = temp;
                j--;
            }
            i++;
        }
        System.out.println("Insertion Sort");
    }
}
//////////////////////////////////////////////////////////////

class BubbleSort implements ISortBehavior {

    public BubbleSort() {

    }

    public void mathSort(int[] inArray) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int j = 1; j < inArray.length; j++) {
                if (inArray[j - 1] > inArray[j]) {
                    int temp = inArray[j - 1];
                    inArray[j - 1] = inArray[j];
                    inArray[j] = temp;
                    swapped = true;
                }
            }
        }
        System.out.println("Bubble Sort");
    }
}

class Driver {

    public static void main(String[] args) {

        int[] array = {1, 5, 3, 7, 3, 3, 6, 7, 5, 0};
        Program p1 = new Matematica();
        Scanner input = new Scanner(System.in);

        

        boolean valid = false;
        while (!valid) {
            
            boolean selection1=false;
            boolean selection2=false;
            
            System.out.println("Select a program to run from the list below:\n[1]Matematica\n[2]MTool\n[3]MyMath\n>>");
            int data = input.nextInt();
            
            
            switch (data) {
                case 1:
                    p1 = new Matematica();
                    selection1=true;
                    break;
                case 2:
                    p1 = new MTool();
                    selection1=true;
                    break;
                case 3:
                    p1 = new MyMath();
                    selection1=true;
                    break;
                default:
                    break;

            }

            System.out.println("Select a method of sorting from the list below:\n[1]Bubble Sort\n[2]Merge Sort\n[3]Insertion Sort\n>>");
            data = input.nextInt();

            switch (data) {
                case 1:
                    p1.changeMethod(new BubbleSort());
                    selection2=true;
                    break;
                case 2:
                    p1.changeMethod(new MergeSort());
                    selection2=true;
                    break;
                case 3:
                    p1.changeMethod(new InsertionSort());
                    selection2=true;
                    break;
                default:
                    break;                   
                    
                
            }
            
            if (selection1&&selection2){
                 valid=true;   
            }

        }

        p1.mathSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

    }

}
