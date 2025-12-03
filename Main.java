import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      boolean[] chptList = new boolean[16]; // Valid chapters are 1-15. 1 means include, 0 exclude. Element 0 unused. 
      int includeChpt;
      int rangeStart = 0;
      int rangeEnd = 0;
      boolean selected = false;
      
      // Get the chapter selections
      for (int i = 1; i < 16; ++i) {
         includeChpt = scnr.nextInt(); 
         if (includeChpt == 1) {
            chptList[i] = true;
         }
         else {
            chptList[i] = false;
         }
      }

      for (int i = 1; i < 16; i++) {
        if (chptList[i]) {
           selected = true;
           rangeEnd = i - 1;
           for (int j = i; j < 16; j++) {
            rangeStart = i;
            if (chptList[j]) {
                rangeEnd++;
            } else {
                break;
            }
           }
           if ((rangeEnd - rangeStart) >= 2) {
            System.out.printf("%d-%d ", rangeStart, rangeEnd);
            i = rangeEnd;
           } else {
            System.out.printf("%d ", i);
           }
        }
      }
      if (selected == false) {
        System.out.print("None ");
      }
      System.out.println();
   }
}
