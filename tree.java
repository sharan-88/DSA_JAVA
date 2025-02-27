
import java.util.*;

public class tree{


static int height = -1;
static class Node 
{
    int data;
    Node left;
    Node right;
};

static Node newNode(int item)
{
    Node temp = new Node();
    temp.data = item;
    temp.left = temp.right = null;
    return temp;
}

public static int findDepth(Node root)
{     
    int level=0;
    Queue<Node>queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i=0;i<size;i++){
            Node current =queue.poll();
            if(current.left != null){
                queue.offer(current.left);
            }
            if(current.right != null){
                queue.offer(current.right);
            }
        }
        level++;

    }



    return level;
}

public static int findDepthRec(Node root){
    if(root == null){
        return 0;
    }
    
    int left =findDepthRec(root.left);
    int right = findDepthRec(root.right);
    int height = Math.max(left,right)+1;

   return height;
}


// find the max elemnt of in the tree

public static int  findmax (Node root){
    if(root == null){
        return 0;
    }
    int left = findmax( root.left);
    int right = findmax(root.right);
    return Math.max(root.data,Math.max(left,right));
      
}

public static boolean search(Node root,int val ){
    if(root == null){
        return false ;
    }
    if(root.data == val){
        return true ;
    }

    return search(root.left,val)  ||
           search(root.right,val);
}


public static ArrayList<Integer> reverseOrder(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    if (root == null) {
        return list;  
    }
    
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    
    Stack<Integer> stack = new Stack<>();

    while (!queue.isEmpty()) {
        Node current = queue.poll();
        stack.push(current.data); 
        
        if (current.right != null) {
            queue.offer(current.right);
        }
        if (current.left != null) {
            queue.offer(current.left);
        }
    }

    while (!stack.isEmpty()) {
        list.add(stack.pop());  // Add the elements from the stack to the list
    }

    return list;
}

public static boolean pathsumExistance(Node root,int pathsum ){
    if(root == null){
        return false ;
    }
    if(root.left == null && root.right==null){
        return pathsum == root.data;
    }

    pathsum=pathsum-root.data;


    return pathsumExistance(root.left, pathsum)  ||
           pathsumExistance(root.right, pathsum) ;
}
public static ArrayList<String> allpath(Node root ){
    ArrayList<String> list = new ArrayList<>();

    helperpathfinder(root ,"",list);


    return list;
    
}
public static void helperpathfinder(Node root,String str,ArrayList<String> list){
    if(root== null){
        return;
    }
    str=str+"->"+root.data; 
    if(root.left == null && root.right ==  null){
        list.add(str);

    }
   
    helperpathfinder(root.left,str,list);
    helperpathfinder(root.right,str,list);


}

public static int totalsum(Node root ){
    if(root == null){
        return 0; 
    }
    return root.data+totalsum(root.left)+totalsum(root.right);
}
public static Node  lca(Node root ,int a, int b){
    if(root == null){
        return root;
    }
    if(root.data == a || root.data==b){
        return root;
    }
    Node left = lca(root.left,a,b);
    Node right = lca(root.right , a , b);
    if(left != null && right != null){
        return root;
    }
    return left == null?right:left;



}


public static ArrayList<Integer>zigzag(Node root,boolean flag){
    ArrayList<Integer> list = new ArrayList<>();
    Deque<Node > queue= new LinkedList<>();
    if(root == null){
        return list;
    }
    queue.offer(root);

    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i= 0;i<size;i++){
            if(flag){
                Node current = queue.removeLast();
                System.out.println(current.data);
                if(current.left != null){
                    queue.addFirst(current.left);
                }
                if(current.right != null){
                    queue.addFirst(current.right);
                }
                  

            }else{
                Node current = queue.removeFirst();
                list.add(current.data);
                if(current.left != null){
                    queue.addLast(current.left);
                }
                if(current.right != null){
                    queue.addLast(current.right);
                }
            }
        }
        flag = !flag;
    }


  return list;
}

public static int fullnode(Node root){
     if(root == null){
        return 0;
    }
    int res=0 ;
    if(root.left != null && root.right != null){
        res++;
    }
    res+=fullnode(root.left)+fullnode(root.right);



    // this question i made mistake 
    return res ;


    
}
public static int halfnode(Node root){
    if(root == null){
       return 0;
   }
   int res=0 ;
   if(root.left != null && root.right == null){
       res++;
   }
   else if(root.left == null && root.right != null){
    res++;
   }
   res+=fullnode(root.left)+fullnode(root.right);



   
   return res ;
  
}

public static int  leafnode(Node root){
    if(root == null){
        return 0;
    }
    int res =0;
    if(root.left == null && root.right == null){
        res++;
    }
    res+=leafnode(root.left)+leafnode(root.right);
    return res;
}






public static void main(String []args)
{
    
    // Binary Tree Formation
    //           5
    //         /  \
    //        10    15
    //      /  \    /  \
    //     20  25  30  35
    //           \
    //            45      
    //            /
    //           50
    //reverse order =    50,45,20,25,30,35,10,15,5 --root ,right ,left  atlast reverse 
    // zig zag => 5,15,10,20,25,30,35,45,50
    Node root = newNode(5);
    root.left = newNode(10);
    root.right = newNode(15);
    root.left.left = newNode(20);
    root.left.right = newNode(25);
    root.left.right.right = newNode(45);
    root.left.right.right.left = newNode(50);
    root.right.left = newNode(30);
    root.right.right = newNode(35);


    // TO-DO list
    // iterative process of in-order,pre-order, post-order 
    //constructing binary tree using inorder and preorder 
    // print  alll ancesstor of all nodes in the tree 
    int answer1 = findDepth(root);
    System.out.println(answer1);

    int level =0;

    int answer2 = findDepthRec(root);
    System.out.println(answer2);
   

    // find the largest number in a tree
    System.out.println("largest node in the tree :"+findmax(root));

    // to search an node in the tree using recursive process
    System.out.println("the node with value "+50+"  present in tree or not : "+search(root, 50));


    // reverse order 
    ArrayList<Integer> answer3 = reverseOrder(root);
    System.out.println();
    for (int num : answer3){
        System.out.print(num+ " ");
    }
    System.out.println();
    // path sum existance 
    int pathsum= 105;
    System.out.println(pathsumExistance(root, pathsum));
    // give an algorithm to print all the path from root to leaf nodes 

    ArrayList<String> answer4= allpath(root);
     for(String num : answer4){
        System.out.println(num);
     }

     // sum of all nodes in the binary tree 
    int total= totalsum(root);
    System.out.println(total);

    // least common anscestor(LCA) 
    // concept is to search the node in left sub tree and right sub tree
    // if we find one node in left and other in the right then 
    // current node is itself LCA
    // if both nodes are found at left then left itself LCA similar to right 
    Node result = lca(root,25,30);
    System.out.println("LCA  : "+result.data);

    //zig-zag traversal
    // not printing correctly 
    ArrayList<Integer> result4=zigzag(root,true);
    System.out.println(result4.toString());

    // find the full nodes 
    int full_num = fullnode(root);
    int half_num = halfnode(root);
    int leaf_num= leafnode(root);
    System.out.println("\ntotal number of full nodes half nodes and leaf nodes in the tree are "+full_num+","+half_num+","+leaf_num);        
    }
    
    
}


