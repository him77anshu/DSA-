// Return the index of the last occurence of an element -> {10,20,20,20,20,30,32} so here last occurence of 20 is at index -> (4)

public class b4 {
    public static int occurence(int arr[], int low, int high, int key) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        }
        if (arr[mid] == key) {
            if (arr[mid + 1] != key) {
                return mid;
            } else {
                return occurence(arr,mid +1,high, key);
            }
        }else if(arr[mid]>key){
            return occurence(arr, low, mid, key);
        }else{
             return occurence(arr, mid+1, high, key);
        }

    }

    // Using Binary search we can find it in O(logN) -> Using iterative method 
    public static int iterative(int arr[] , int low , int high , int key ){
        while(low<=high){
            int mid = (low +high)/2;
            if(arr[mid]==key ){
                if(arr[mid+1]!=key ){
                    return mid ;
                }else{
                    low = mid+1;
                }
            }else if(arr[mid]>key){
                 high = mid-1;
            }else{
                 low = mid+ 1;
            }
        }
        return -1;
    }

    
    public static void main(String[] args) {
        int arr[] ={11,12,12,13,13,15,20};
        System.out.println(occurence(arr, 0, arr.length, 13));
        System.out.println(iterative(arr,0, arr.length, 13));
    }
}
