public class sieve {
    // find and print prime numbers less than equal to n ???
    public static void main(String[] args) {
        int n=40;
        boolean[] prime=new boolean[n+1];
       // System.out.println(prime[2]); // since n has to be included
        isprime(n,prime);

    }
    static void isprime(int n,boolean[] prime){
        for(int i=2;i*i<=n;i++ ){
            if(!prime[i]){
                for(int j=i*2;j<=n;j+=i){
                    prime[j]=true;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(!prime[i]){
                System.out.println(i);
            }
        }
    }
    
}
/* 
 example n =19
since squrt of 19 is 4.955 till 4 we need to check
WHEN WE CREATE BOOLEAN ARRAY ALL VALUES INTIALIZED TO FALSE  1--NOT PRIME   2--PRIME
 * 1   
 * 2            CHECK ITS FALSE IF FALSE MAKE ALL ITS MULTIPLE TO TRUE EXPECT ITSSELF
 * 3          CHECK its false or not if false make all its multiple true
 * 4    TRUE  // since its true itmeans its multiple is already appeared
 * 5                       
 * 6    TRUE   no need
 * 7
 * 8    TRUE
 * 9             TRUE
 * 10   TRUE
 * 11
 * 12   TRUE
 * 13
 * 14   TRUE
 * 15           TRUE
 * 16   TRUE
 * 17
 * 18   TRUE  no need
 * 19
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
