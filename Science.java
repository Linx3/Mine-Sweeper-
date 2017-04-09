import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Science {
  
//  public static int h=0; 

  
  
  public static int reduce(int[] sr, int[] sc, int pos){
   sr[pos]=-1;
   sc[pos]=-1;
   List<Integer>list=new ArrayList<Integer>(); 
   List<Integer>list2=new ArrayList<Integer>();     
    for(int i:sr)
      list.add(i);
    for(int i:sc)
      list.add(i);
    
    int h=list.size(); 
    for (int i=1; i<h;i++){
      for (int k=0; k<i; k++){
        if(list.get(i)==list.get(k) && list2.get(i)==list2.get(k)){
          list.remove(i);
          list2.remove(i);
          pos--;
        }

      }
        h=pos;
    }
    
    for(int i=0; i<list.size();i++){
      if (list.get(i)==-1){
        list.remove(i);
        list2.remove(i);
      }
    }
    
    for(int i=0; i<list.size();i++){
      sr[i]=list.get(i);
      sc[i]=list2.get(i);
    }
    
    sr[pos]=sr[0];
    sc[pos]=sc[0];
    
    return (list.size());
    
  }
  
  
  public static void main (String[] args){
    int[] nums= new int[]{0,0,1,0,1,0,1,0,0,0,0};
    int[] nums2= new int[]{1,2,2,2,1,1,3,3,0,0,0};
    List<Integer> list = new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();
    
    for (int i:nums){
      list.add(i);
    }
    
    for(int i: nums2){
      list2.add(i);
    }
      
    /*
    int length=list2.size();
    int i=0;
       
    while (i<length){
          System.out.println(length);
          
      for (int k=0; k<i; k++){
        if(list.get(i)==list.get(k) && list2.get(i)==list2.get(k)){
          list.remove(i);
          list2.remove(i);
         
          System.out.println();         
          for (int g=0; g<list.size();g++)
            System.out.print(list.get(g));
          System.out.println();
          for (int b=0; b<list2.size();b++)
            System.out.print(list2.get(b));
    
           length=list.size();

        }
    }
    i++;

    }
    */
    int h=list.size(); 
    int count=0;
    for (int i=0; i<h;i++){
      for (int k=0; k<i; k++){
        if(list.get(i)==list.get(k) && list2.get(i)==list2.get(k)){
          count++;
        }
        
        if (count>0){
          list.remove(i);
          list2.remove(i);
          count=0;
          break;
        }
        h=list.size();
      }
        h=list.size();
    }
    
    for(int i=0; i<list.size();i++){
      if (list.get(i)==-1){
        list.remove(i);
        list2.remove(i);
      }
    }
    
          System.out.println();    
          for (int g=0; g<list.size();g++){
            System.out.print(list.get(g)); 
          }
          System.out.println();     
          for (int b=0; b<list2.size();b++){
            System.out.print(list2.get(b));

          }

  }

}