import java.util.Scanner;

public class FCFS1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of process : ");
        int process = input.nextInt();
        System.out.println("You entered " + process);
        int[][] arr = new int[process][7];

        for(int i=0;i<process;i++)
        {
            arr[i][0]=i+1;
            System.out.println("Enter arrival time of process "+ (i+1) +" : " );
            arr [i][1]=input.nextInt();
  
            
            System.out.println("Enter Burst time of process "+ (i+1) +" : " );
            arr [i][2]=input.nextInt();
            arr [i][6]=0;
        }

        int count = 0 , min = 0 ,counter=0, preFT=0;

        while(count<process)
        {
            for (int i=0;i<process;i++)
            {
                if (min>=arr[i][1] && arr[i][6]==0)
                {
                    count= count+1;
                    min=arr[i][1];
                    // System.out.println("min == "+ min );
                    if (arr[i][1]>preFT)
                    {
                        counter=arr[i][1];
                        // System.out.println("in if loop counter "+ counter );

                    }
                    else{
                        counter=preFT;
                        // System.out.println("in else loop counter "+ counter );

                    }
                    arr[i][3]=counter + arr[i][2]; //calculating finish time
                    // System.out.println("finish time == "+ arr[i][3] );

                    arr[i][5]=arr[i][3] - arr[i][1]; //calculating turnaround time
                    // System.out.println("turnaround  time == "+ arr[i][5] );

                    arr[i][4]=arr[i][5] - arr[i][2]; //calculating waiting time
                    // System.out.println("waiting time  == "+ arr[i][4] );

                    // counter = arr[i][3];
                    arr[i][6]=1;
                    min=min+1;
                    
                    preFT=arr[i][3];
                    // System.out.println("counter == "+ counter );

                    // System.out.println("perFT == "+ preFT );

                }
            }
            min++;
        }
        //Display process

        System.out.println("   \n  \t  :  table :\n   " );
        System.out.println(" : P : AT : BT : FT : WT : TT :" );


        for(int i=0;i<process;i++)
        {
            System.out.print(" : "+arr[i][0] + " : ");
            System.out.print(arr[i][1] + "  : ");
            System.out.print(arr[i][2] + "  : ");
            System.out.print(arr[i][3] + "  : ");
            System.out.print(arr[i][4] + "  : ");
            System.out.println(arr[i][5] + "  : ");
        }
       
    
        // int arr[process][5];
    
    }

}
