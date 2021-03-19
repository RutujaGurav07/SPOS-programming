import java.util.Scanner;
import java.util.LinkedList;

public class SJF_primeetive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of process : ");
        int process = input.nextInt();
        System.out.println("You entered " + process);
        int[][] arr = new int[process][6];
        int temp, counter = 0, wq = 0;
        int[][] waitingqueue;
        waitingqueue = new int[10][2];
        LinkedList raedyqueue = new LinkedList();

        for (int i = 0; i < process; i++) {

            arr[i][0] = i + 1;
            System.out.println("Enter Arrival time of process " + (i + 1) + " : ");
            arr[i][1] = input.nextInt();

            System.out.println("Enter Burst time of process " + (i + 1) + " : ");
            arr[i][2] = input.nextInt();

        }

        // Sorting array

        for (int i = 0; i < process - 1; i++) {
            for (int j = 0; j < process - i - 1; j++) {

                if (arr[j][1] > arr[j + 1][1]) {
                    for (int k = 0; k < 2; k++) {
                        temp = arr[j][k];
                        arr[j][k] = arr[j + 1][k];
                        arr[j + 1][k] = temp;
                    }
                }
            }
        }
        // calculation
        int p = 0;
        while (p < process) {
            for (int i = 0; i < process; i++) {
                if (arr[i][1] == counter) {
                    // add in waiting queue
                    waitingqueue[wq][0] = arr[i][2];
                    waitingqueue[wq][1] = arr[i][0];
                    wq++;

                }

            }
            // System.out.println("counter =" + counter + " wq : " + wq);

            int min = waitingqueue[0][0], index = 0;
            for (int i = 0; i < wq; i++) {
                if (min >= waitingqueue[i][0]) {
                    min = waitingqueue[i][0];
                    index = i;
                }

            }
            // System.out.println("index : " + index);

            if (waitingqueue[index][0] == 0) {
                // remove from wqiting queue
                for(int i=0;i<process;i++)
                {
                    if (arr[i][0]==waitingqueue[index][1])
                    {
                        arr[i][3]=counter;//finishing time
                        arr[i][5]=arr[i][3]-arr[i][1];//turnout time
                        arr[i][4]=arr[i][5]-arr[i][2];//waiting  time

                    }
                } 
                waitingqueue = removeTheElement(waitingqueue, index);
                   
                wq--;
                p++;

                // System.out.println("remove index:" + index + "element form waiting queue .wq : " + wq);
                min = waitingqueue[0][0];
                for (int i = 0; i < wq; i++) {
                    if (min >= waitingqueue[i][0]) {
                        min = waitingqueue[i][0];
                        index = i;
                    }
    
                }
                waitingqueue[index][0]--;

            } else {
                waitingqueue[index][0]--;

            }

            for (int i = 0; i < wq; i++) {
                System.out.println("i= " + i + "waiting q 0 :" + waitingqueue[i][0]);
                System.out.println("waiting Q 1: " + waitingqueue[i][1]);
            }

            raedyqueue.add(waitingqueue[index][1]);

            counter++;

        }

        // display data

        System.out.println("   \n  \t  :  table : \n \n Assumming all the process arrival in 0 interval\n ");
        System.out.println(" : No : AT : BT : FT : WT : TT :");

        for (int i = 0; i < process; i++) {
            System.out.print(" : " + arr[i][0] + " : ");
            System.out.print(arr[i][1] + "  : ");
            System.out.print(arr[i][2] + "  : ");
            System.out.print(arr[i][3] + "  : ");
            System.out.print(arr[i][4] + "  : ");
            System.out.println(arr[i][5] + "  : ");
        }
        System.out.println(raedyqueue);

    }

    public static int[][] removeTheElement(int[][] arr, int index) {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0 || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[][] anotherArray = new int[arr.length - 1][2];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            else {
                anotherArray[k][0] = arr[i][0];
                anotherArray[k][1] = arr[i][1];
                k++;
            }
        }

        // return the resultant array
        return anotherArray;
    }

}
