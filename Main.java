package projecteuler;

import java.io.File;

/**
 *
 * @author Ariel Krakowski
 */
public class Main {

    /**
     * @param args the command line arguments
     */
	
	//include files locally**
	
    public static void main(String[] args) {
    	

        long startTime = System.nanoTime();
        
        Euler e = new Euler();
		e.e13();  
		
		File f18 = new File("nums-p18");
		File f67 = new File("triangle.txt");
		e.e18(f18, 15); 
		e.e18(f67, 100);
		
		
		e.e34();      		
		e.e30();
        
        //other solutions
//        problem1 p = new problem1();
//        prob20 p20 = new prob20();
//        Prob21 p21 = new Prob21();
//        p25p p25 = new p25p();
        //LargeInputProbs lip = new LargeInputProbs();
                
        printRunningTime(startTime);

    }
    
    public static void printRunningTime(long startTime){
      long endTime = System.nanoTime();
      double seconds = (double) (endTime-startTime) / 1000000000.0;
      System.out.println("Running time: " + seconds + " seconds");
    	
    }

}
