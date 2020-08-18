/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3;

/**
 *
 * @author Hector Felix
 */

// TIME COMPLEXITY EXPLANATION
// O (n * logn) solution because our data is called recursively. The set of data is continually divided 
// in half, and each part is dealt with independently. In our case, LHM and RHM are always split and companrisons
// made inside of them happen independent of each other. These are similar to mergesort and heapsort


import java.util.Arrays;
public class FindMajority {

    public static void main(String[] args) {
        Integer[] A = {8,1,2,1,7,3,1};
        Integer[] B = {4,2,0,9,9,1,9};
        System.out.println("A[]: "+Arrays.toString(A));
        System.out.println("Array A Majority: "+FindMajority(A, 0, A.length - 1));
        System.out.println("\nB[]: "+Arrays.toString(B));
        System.out.println("Array B Majority: "+FindMajority(B, 0, A.length - 1)+'\n');
        
    }

    static public Integer FindMajority(Integer[] A, int low, int high) {
        if (low == high) {
            return A[low];
        }

        Integer leftMajority = FindMajority(A, low, ((low + high) / 2));
        Integer rightMajority = FindMajority(A, (((low + high) / 2) + 1), high);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }
        int currentLeftMajority = 0, currentRightMajority = 0;
        
//        System.out.println("Low: "+ low);
        
        for (int i = 0; i <= high; i++) {
            if (A[i] == leftMajority) {
                currentLeftMajority++;
            } else if (A[i] == rightMajority) {
                currentRightMajority++;
            }
        }
//        System.out.println("CLM: "+currentLeftMajority);
//        System.out.println("CRM: "+currentRightMajority);
        
        if (currentLeftMajority > (A.length / 2)) {
            return leftMajority;
        } else if (currentRightMajority > (A.length / 2)) {
            return rightMajority;
        } else {
            return null;
        }
    }
}
