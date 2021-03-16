import java.util.Scanner;
import java.util.LinkedList;
 
public class FIFO_pg_replacement {

    public static void main(String[] args) {

        // taking input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter frame size : ");
        int framesize = input.nextInt();
        System.out.println("Enter framestring lenght : ");
        int size = input.nextInt();
        int[] frame_string = new int[size];
        int pg_fault = 0, pg_hit = 0;
        System.out.println(" Enter frame string : ");
        LinkedList frames = new LinkedList();
        
        //calculation

        for (int i = 0; i < size; i++) {
            frame_string[i] = input.nextInt();
            if (frames.contains(frame_string[i])) {
                pg_hit++;
            }
            if (!frames.contains(frame_string[i]) && frames.size()==framesize) {
                frames.remove();
                frames.add(frame_string[i]);
                pg_fault++;
            }
            if (!frames.contains(frame_string[i]) ) {
                frames.add(frame_string[i]);
                pg_fault++;
            }
        }

        // display page fault page hit
        
        System.out.println("page hit: " + pg_hit);
        System.out.println("page fault : " + pg_fault);

    }
}
