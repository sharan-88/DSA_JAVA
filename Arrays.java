import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
public class Arrays {

    //List<String>list= new ArrayList<>();--->  dynamic list creation
    //  int[] ar = new int[ size of the list]  OR int[] arr = new int[]{1,2,3,4,5,6,,,,,} ---->fixed size
    //  
    //   array listmethods
    //  list.add()
    //   list.put()
    //   list.get()
    //   list.indexOf()  // gives fist occurance of value
    // list.lastIndexOf()
    //   list.size()
    //    list.contains()
    //    list.isEmpty()


    public static void main(String[] args){
       /* BASIC ARRAY OPERATIONS 
        List<String>list= new ArrayList<>();
        System.out.println(list.isEmpty());
        list.add("sha");
        list.add("shree");
        list.add("jyo");
        list.get(1);
        
        list.add("sha");
        System.out.println(list);
        System.out.println(list.indexOf("sha"));
        System.out.println(list.lastIndexOf("sha"));
        if(list.contains("jyo")) System.out.println("true");
        else System.out.println("no ");
        System.out. println(list.size());
        
*/
        // move zeros to left of the array 
        int[] arr = new int[] {1,0,21,2,0,3,4,5};
        move_zeros(arr);
        for(int i:arr){
        System.out.println(i);
        }


        // kadens algorithm ----> IMP
        int[] arr1 = new int[]{1,-2,2,3,-1,4};
         int max_sum = kadens(arr1);
        System.out.println(max_sum);

        // reverse the array without using extra space 
         char[] array = new char[]{'A','B','C','D','E','F','G'};
         reverse_char(array);
         for( char i : array){
            System.out.print(i+" ");
            System.out.println(' ');
         }
        
        // pre-fix /runing sum 
           System.out.println( "prefix sum");
        int[] a1 = new int[]{ 10,20,30,40,50,60};
        prefix_sum(a1);
        System.out.println("prefix array is  ");
        for(int i: a1){
            System.out.print(i+" ");
        }
        // give the sumn of subarray  from index  1 to 4 
        System.out.println("\n");
        int sum = a1[4]-a1[1-1];
        System.out.println(sum);




        // product of array expect it self 
       // 2,3,4,5,6
    // ans 360 240,180,144,120  
     int[] sha =new int[]{2,3,4,5,6} ;
      int[] ans =product(sha);
      
      for(int i=0;i<ans.length;i++){
        System.out.println(ans[i]);
      }

      //  index of first unique character in a string 
        System.out.println(unique_character("aaab"));
        System.out.println((char)('a'+1));// type casting is done by representing reduried data type in curve bracket

// ismoric string example odd & egg
    System.out.println(isomeric("egg","odd"));


// minimum size of subarray such that sum of subarray >k
    int[] array2 = new int[]{2,3,4,2,2,2};
       int min =min_size_subarray(array2,8);
      System.out.println(" min_size  of subarray"+min);

     

       // maximum length of subarray with k distinct elements 
        int max1 =  max_sub_k_distinct("aaabaccdaa",2);
        System.out.println(max1);


        // reverse only characetr in a strings  # two pointers
        String str ="s_a-ahs!dn*w#";
        reverse_only_character(str);
        System.out.println(str);
        //char[] a= String.toCharArray("shdjk_dkdk");
        //System.out.println(a[2]);


        // string compression 
        String str12 = "aaabbcddde";
        String ans12 =string_compression(str12);
        System.out.println(ans12);

   
    }
     

    public static String string_compression(String str){
         StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            int count =0;
            char ch = str.charAt(i);
            while(i<str.length() && str.charAt(i)== ch){
                count++;
                i++;
            }
            if(count ==1){
                sb.append(ch);
                        }
            if(count>1){
                sb.append(ch);
                sb.append(count);

             } 
            }
            System.out.println(sb.toString());
             return sb.toString();
        
    }

























    public static void reverse_only_character(String str){
        int i=0;
        int j = str.length()-1;
        while(i<j){
            char start = str.charAt(i);
            char  end  = str.charAt(j);
            if( !is_character(start)) start++;
            else if( !is_character(end)) end++;
            else{
                char temp = start;
                start = end ;
                end = temp;
                i++;
                j++;
            }

        }
        System.out.println(str);

        
        
    }


    public static boolean is_character(char c){
        if((c>=65 && c<=90)||c>=97 && c<=122) return true;
        else return false;
        
    }



     
    public static int  max_sub_k_distinct(String s,int k){
    int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            while (charFrequency.size() > k) {
                char leftChar = s.charAt(windowStart);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

       













     public static int min_size_subarray(int[] arr, int k){
        int final_min = Integer.MAX_VALUE;
        
        int sum =0;
         int start =0;
          for(int end =0;end<arr.length;end++){
            sum+= arr[end] ;
            while(sum>k){
                final_min = Math.min(final_min,end-start+1);
                sum-= arr[start];
                start++;

            }

          }
          return final_min;
     }

















    public static boolean isomeric(String s1,String s2){
        if(s1.length() != s2.length()) return false ;
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
             char c1= s1.charAt(i);
             char c2 =s2.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1) != c2) return false ;
            }
            if(! map.containsKey(c1) ){
                if(map.containsValue(c2)) return false;
                map.put(c1,c2);
            }
            
                
            
        }
        return true;
    }









    public static char unique_character(String str){
        int[] fre = new int[26];
        for(char c:str.toCharArray()){
            fre[c-'a']++;
        }
        for(char c : str.toCharArray()){
            if(fre[c-'a']==1) return c;
        }
        
        return '\0'; // null character
    
    }
    
    public static int[] product(int[] array){
        int[] arr1 = new int[array.length];
        // since it is prefix starting element has to be filled 
        arr1[0] = array[0];
        for(int i=1;i<array.length;i++){
            arr1[i]= arr1[i-1]*array[i];
            System.out.println(arr1[i]);
        }
        // arr1 = 2,6,24,120,720,
        // 
        int postfix =1;
       for(int i=array.length-1;i>=0;i--){
        if(i==0) array[i]=postfix;
        else{
         arr1[i] = arr1[i-1]* postfix;
         postfix *= array[i];
        }
         
       }
       return arr1;
    }













    public static void prefix_sum(int[] array){
         for(int i=1;i<array.length;i++){
            array[i]=array[i]+array[i-1];
         }
    }

    public static int kadens(int[] arr){
        int max = 0;
        int super_max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            max+=arr[i];
            if(max>super_max){
                super_max = max ;

            }
            if(max <0){  // when max becomes less than zero then we should replace value by zero
                max = 0;
            }
        }
        return super_max;
    }


    public static void move_zeros(int[] arr){
        int i=0;
         int j=0;
        while(j<arr.length){
            if(arr[j] != 0){
                arr[i]= arr[j];
                i++;
            }
            j++;
        }
        while(i<arr.length){
            arr[i]=0;
            i++;
        }
    }

        public static void reverse_char( char[] array){
            int length = array.length;
            for(int i=0;i<=length/2;i++){
                swap(array,i,length-i-1);
            }
        }
         public static void swap( char[] array,int i, int j ){
            char a = array[i];
            array[i] = array[j];
            array[j] = a;
        }
    }


