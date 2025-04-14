 /*You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k
 representing the number of students. The task is to allocate books to each student such that:
   Each student receives atleast one book.
   Each student is assigned a contiguous sequence of books.
   No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, 
find the arrangement where the student who receives the most pages still has the smallest possible maximum.

 */
public class BookAllocation {
    class Solution {
        public static int findPages(int[] arr, int k) {
            if(arr.length<k){
                return -1 ;
            }
            int max=arr[0];
            int sum =0;
            for(int i=0; i<arr.length ; i++){
               sum += arr[i];
               
               if(arr[i]>max){
                   max=arr[i];
               }
            }
            int low =max; 
            int high =sum ;
            int ans =0 ;
            while(low<=high){
               int mid = low + (high-low)/2;
               if(issafe(arr, mid , k)){
                   ans=mid;
                   high=mid-1;
               }else{
                   low = mid+1;
               }
            }
            
            return ans ;
            
        }
        
        public static boolean issafe(int arr[] ,int mid , int k ){
             int sum =0 ;
             int student =1;
             int i=0;
             while(i<arr.length){
                 if(sum+arr[i]<=mid){
                     sum += arr[i];
                     i++;
                 }else{
                     student ++;
                     sum=0;
                 }
                 if(student >k){
                     return false ;
                 }
             }
             
             return true ;
        }
    }
}
