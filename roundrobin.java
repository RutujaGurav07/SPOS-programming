import java.util.Scanner;
import java.util.LinkedList;


public class roundrobin {
    public static void main(String[] args) {

        // taking input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of process : ");
        int process = input.nextInt();
        System.out.println("You entered " + process);
        System.out.println("Enter time slice: ");
        int timeslice = input.nextInt();
        int temp,counter = 0;
        int[][] arr = new int[process][6];
        LinkedList raedyqueue = new LinkedList();
        LinkedList ganttchart = new LinkedList();


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
        //calculation

        int p=0, pervious_process=-1;
        while (p<process)
        {
            for (int i=0;i<process;i++)
            {
                if (arr[i][1]==counter)
                {
                    raedyqueue.add(arr[i][0]);

                }

            }
            if (pervious_process != -1)
            {
                raedyqueue.add(pervious_process);
            }
           int cureent_process= (int) raedyqueue.poll();
                System.out.println("Current process"+cureent_process);
                int t=0;
                while(t<timeslice)
                {
                    ganttchart.add(arr[cureent_process][0]);                    
                }
                System.out.println("Ganttchart"+ganttchart);

                // ganttchart.add(raedyqueue.removeFirst());
                counter++;
               
            
        }
        System.out.println(raedyqueue);
        System.out.println(ganttchart);
    }
}
