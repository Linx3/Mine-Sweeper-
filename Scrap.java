import java.util.*; 
import java.util.Arrays;
import java.util.List;
  

public class Scrap{

//makes the grid for the game by looping through a 2D array and setting each value to a "*"
    public static String [][] makeGrid(int n){
      String [][] plate= new String [n][n]; 
      for (int i=0; i<plate.length; i++){
        for(int k=0; k<plate[i].length; k++){
          plate[i][k]= "*"; 
        }
      }
      return plate; 
  }
  
    
//return an array of random number from 0 to n
    public static int[] randomGenerator(int range, int n){
      int [] collection = new int[range];
      for (int i=0; i<collection.length;i++){
        collection[i]= (int)(Math.random()*(n));
      }
      return collection;  
  }
  
    
//makes the mines by calling the randomGenerator method and setting each pair to "M"
    public static String[][] makeMines(int n){
      int numMines= (int) (n*n*0.15625)+2; 
      String [][] mines= makeGrid(n); 
      int [] rows= randomGenerator(numMines, n); 
      int [] cols = randomGenerator(numMines, n);
      for (int i =0; i<numMines; i++){
        mines[rows[i]][cols[i]]= "M"; 
      }
      return mines;
  }  
    

// takes the grid with mines as an parameter return another 2D array with numbers that show the amount of adjacent mines     
   public static String[][] nums (String[][]grid){
    int mm=0; 
     for (int c=0; c<grid.length;c++){
       for (int d=0; d<grid[c].length;d++){
        
      if (grid[c][d].equals("M"))
       grid[c][d]="M";
        
      else if (c==0 && d==0){
           if(grid[c][d+1].equals("M"))
             mm++;         
           if (grid[c+1][d].equals("M"))
             mm++;
           if (grid[c+1][d+1].equals("M"))
             mm++;
           if (mm>0)
             grid[c][d]=""+mm; 
           mm=0; 
           }
         
         else if (c==0 && d==grid[c].length-1){
           if(grid[c][d-1].equals("M"))
             mm++;         
           if (grid[c+1][d].equals("M"))
             mm++;
           if (grid[c+1][d-1].equals("M"))
             mm++;
           if (mm>0)
             grid[c][d]=""+mm;
           mm=0; 
           }

         else if (c==grid.length-1 && d==0){
           if(grid[c][d+1].equals("M"))
             mm++;         
           if (grid[c-1][d].equals("M"))
             mm++;
           if (grid[c-1][d+1].equals("M"))
             mm++;
           if (mm>0)
             grid[c][d]=""+mm;
           mm=0; 
           }
         
         else if (c==grid.length-1 && d==grid[c].length-1){
           if(grid[c][d-1].equals("M"))
             mm++;         
           if (grid[c-1][d].equals("M"))
             mm++;
           if (grid[c-1][d-1].equals("M"))
             mm++;
           if (mm>0)
             grid[c][d]=""+mm;
           mm=0; 
           }
         
         
         else if (c==0){
           if(grid[c][d+1].equals("M"))
          mm++;
           if(grid[c][d-1].equals("M"))
          mm++;
           if(grid[c+1][d+1].equals("M"))
             mm++;
           if(grid[c+1][d].equals("M"))
             mm++;
           if(grid[c+1][d-1].equals("M"))
             mm++;
           if(mm>0)
             grid[c][d]=""+mm;
           mm=0;
         }
         
         else if (c==grid.length-1){
           if(grid[c][d+1].equals("M"))
             mm++;
           if(grid[c][d-1].equals("M"))
             mm++;
           if(grid[c-1][d].equals("M"))
             mm++;
           if(grid[c-1][d+1].equals("M"))
             mm++;
           if(grid[c-1][d-1].equals("M"))
             mm++;
           if(mm>0)
             grid[c][d]=""+mm;
           mm=0;
         }
         
         else if (d==0){
           if(grid[c+1][d].equals("M"))
             mm++;
           if(grid[c-1][d].equals("M"))
             mm++;
           if(grid[c][d+1].equals("M"))
             mm++;
           if(grid[c-1][d+1].equals("M"))
             mm++;
           if(grid[c+1][d+1].equals("M"))
             mm++;
           if(mm>0)
             grid[c][d]=""+mm;
           mm=0;
         }
         
         else if (d==grid[c].length-1){
           if(grid[c+1][d].equals("M"))
             mm++;
           if(grid[c-1][d].equals("M"))
             mm++;
           if(grid[c][d-1].equals("M"))
             mm++;
           if(grid[c-1][d-1].equals("M"))
             mm++;
           if(grid[c+1][d-1].equals("M"))
             mm++;
           if(mm>0)
             grid[c][d]=""+mm;
           mm=0;
         }
          
         else{
              if (grid[c+1][d].equals("M")){
                mm++;}
              if (grid[c-1][d].equals("M")){
                mm++;}
              if (grid[c][d+1].equals("M")){
                mm++;}
              if (grid[c][d-1].equals("M")){
                mm++;}
              if (grid[c+1][d-1].equals("M")){
                mm++;}
              if (grid[c+1][d+1].equals("M")){
                mm++;}
              if (grid[c-1][d-1].equals("M")){
                mm++;}
              if (grid[c-1][d+1].equals("M")){
              mm++;}
              if (mm>0){
                grid[c][d]=""+mm;} 
              mm=0;     
         }
         }       
         }
     return grid; 
   }
   
   
// the method modifies two array; if an user selects an empty space with adjacent empty spaces, the method acquires the location of all its adjacent empty spaces; 
// the method return int i, which is the latest index of the array modified
public static int getLocation(int rows, int cols, String[][]input, String[][] mines, int i, int[] sr, int[] sc){
  if (rows==0 && cols ==0){
     if(mines[rows+1][cols].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols;
      i++;
     }
     if(mines[rows+1][cols+1].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols+1;
      i++;
     }
     if(mines[rows][cols+1].equals("*")){
      sr[i]=rows;
      sc[i]=cols+1;
      i++;
     } 
    }
    
    else if (rows==0 && cols==mines[0].length-1){
     if(mines[rows+1][cols].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols;
      i++;
     }
     if(mines[rows+1][cols-1].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols-1;
      i++;
     }
     if(mines[rows][cols-1].equals("*")){
      sr[i]=rows;
      sc[i]=cols-1;
      i++;
     }   
    }
    
    else if (rows==mines.length-1 && cols==0){
     if(mines[rows][cols+1].equals("*")){
      sr[i]=rows;
      sc[i]=cols+1;
      i++;
     }
     if(mines[rows-1][cols].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols;
      i++;
     }
     if(mines[rows-1][cols+1].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols+1;
      i++;
     }   
    }
 
    else if (rows==mines.length-1 && cols==mines[mines.length-1].length-1){
     if(mines[rows][cols-1].equals("*")){
      sr[i]=rows;
      sc[i]=cols-1;
      i++;
     }
     if(mines[rows-1][cols-1].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols-1;
      i++;
     }
     if(mines[rows-1][cols].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols;
      i++;
     }   
    }
    
    else if (rows==0){
     if (mines[rows][cols-1].equals("*")){
      sr[i]=rows;
      sc[i]=cols-1; 
      i++; 
     }
     if (mines[rows][cols+1].equals("*")){
      sr[i]=rows;
      sc[i]=cols+1; 
      i++; 
     }     
     if (mines[rows+1][cols-1].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols-1; 
      i++; 
     }    
     if (mines[rows+1][cols+1].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols+1; 
      i++; 
     }     
     if (mines[rows+1][cols].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols; 
      i++; 
     }
    }
    
    else if (rows==mines.length-1){
     if (mines[rows][cols-1].equals("*")){
      sr[i]=rows;
      sc[i]=cols-1; 
      i++; 
     }
     if (mines[rows][cols+1].equals("*")){
      sr[i]=rows;
      sc[i]=cols+1; 
      i++; 
     }     
     if (mines[rows-1][cols-1].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols-1; 
      i++; 
     }    
     if (mines[rows-1][cols+1].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols+1; 
      i++; 
     }     
     if (mines[rows-1][cols].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols; 
      i++; 
     }
    }
    
    
    else if (cols==0){
     if (mines[rows][cols+1].equals("*")){
      sr[i]=rows;
      sc[i]=cols+1; 
      i++; 
     }
     if (mines[rows-1][cols+1].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols+1; 
      i++; 
     }     
     if (mines[rows-1][cols].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols; 
      i++; 
     }    
     if (mines[rows+1][cols+1].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols+1; 
      i++; 
     }     
     if (mines[rows+1][cols].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols; 
      i++; 
     }
    }   
    
    else if (cols==mines[rows].length-1){
     if (mines[rows][cols-1].equals("*")){
      sr[i]=rows;
      sc[i]=cols-1; 
      i++; 
     }
     if (mines[rows-1][cols-1].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols-1; 
      i++; 
     }     
     if (mines[rows-1][cols].equals("*")){
      sr[i]=rows-1;
      sc[i]=cols; 
      i++; 
     }    
     if (mines[rows+1][cols-1].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols-1; 
      i++; 
     }     
     if (mines[rows+1][cols].equals("*")){
      sr[i]=rows+1;
      sc[i]=cols; 
      i++; 
     }
    }   
    
 
    else{
     if (mines[rows-1][cols].equals("*")){
           sr[i]=rows-1;
           sc[i]=cols;
           i++;
          }
     if (mines[rows+1][cols].equals("*")){
           sr[i]=rows+1;
           sc[i]=cols;
           i++;
          }
     if (mines[rows][cols-1].equals("*")){
           sr[i]=rows;
           sc[i]=cols-1;
           i++;
          }
     if (mines[rows-1][cols-1].equals("*")){
           sr[i]=rows-1;
           sc[i]=cols-1;
           i++;
          }
     if (mines[rows+1][cols-1].equals("*")){
           sr[i]=rows+1;
           sc[i]=cols-1;
           i++;
          }
     if (mines[rows][cols+1].equals("*")){
           sr[i]=rows;
           sc[i]=cols+1;
           i++;
          }
     if (mines[rows+1][cols+1].equals("*")){
           sr[i]=rows+1;
           sc[i]=cols+1;
           i++;
          }
     if (mines[rows-1][cols+1].equals("*")){
           sr[i]=rows-1;
           sc[i]=cols+1;
           i++;
          }
    }
  
  
  return i;
    
} 
   

// the method take the two arrays of rows and columns locations and gets rid of the repeating locations to save memory space;
public static int reduce(int[] sr, int[] sc, int pos){
    List<Integer>list=new ArrayList<Integer>(); 
    List<Integer>list2=new ArrayList<Integer>();     
     for(int i:sr)
       list.add(i);
     for(int i:sc)
       list2.add(i);
     
    int count=0;
     for (int i=0; i<pos+1;i++){
       for (int k=0; k<i; k++){
         if(list.get(i)==list.get(k) && list2.get(i)==list2.get(k)){
           count++;
           }
        if (count>0){ 
           list.remove(i);
           list2.remove(i);
           pos--;
           count=0;
           break;
         }
       }
     }
     
     for(int i=0; i<list.size()-1;i++){
       if (list.get(i)==0 && list2.get(i)==0 && list.get(i)==0 && list2.get(i)==0){
         list.remove(i);
         list2.remove(i);
       }
     }
     
     for(int i=0; i<list.size();i++){
       sr[i]=list.get(i);
       sc[i]=list2.get(i);
     }   
     return (pos);     
   }


public static String[][] getBoxes(String[][] input, String[][]mines, int rows, int cols){
  int []sr=new int[200000];
  int []sc=new int[200000];
  sr[0]=rows;
  sc[0]=cols; 
  int z=1;

  //loops through each array element and gets the location of their surrounding empty boxes
  for(int a=0; a<10000; a++){
      z=getLocation(sr[a], sc[a], input, mines,z, sr, sc);
      //z=reduce(sr,sc,z);
   
     int r=0;
     int c=0;
     
//reveals the surrounding locations of each box
     for (int k=0; k<z; k++){
      r=sr[k];
      c=sc[k];
      if (r==0 && c==0){
       input[r][c+1]=mines[r][c+1];
       input[r+1][c+1]=mines[r+1][c+1]; 
       input[r+1][c]=mines[r+1][c]; 
      }
      
      else if (r==0 && c==mines[0].length-1){
       input[r][c-1]=mines[r][c-1];
       input[r+1][c-1]=mines[r+1][c-1]; 
       input[r+1][c]=mines[r+1][c];        
      }
      
      else if (r==mines.length-1 && c==0){
       input[r][c+1]=mines[r][c+1];
       input[r-1][c+1]=mines[r-1][c+1]; 
       input[r-1][c]=mines[r-1][c];        
      }      
     
      else if (r==mines.length-1 && c==mines[r].length-1){
       input[r][c-1]=mines[r][c-1];
       input[r-1][c-1]=mines[r-1][c-1]; 
       input[r-1][c]=mines[r-1][c];  
      }       
      
      else if (r==0){
       input[r][c-1]=mines[r][c-1];
       input[r][c+1]=mines[r][c+1];
       input[r+1][c-1]=mines[r+1][c-1];
       input[r+1][c+1]=mines[r+1][c+1];       
       input[r+1][c]=mines[r+1][c];
      }

      else if (r==mines.length-1){
       input[r][c-1]=mines[r][c-1];
       input[r][c+1]=mines[r][c+1];
       input[r-1][c-1]=mines[r-1][c-1];
       input[r-1][c+1]=mines[r-1][c+1];       
       input[r-1][c]=mines[r-1][c];
      }

      else if (c==0){
       input[r][c+1]=mines[r][c+1];
       input[r-1][c+1]=mines[r-1][c+1];
       input[r-1][c]=mines[r-1][c];
       input[r+1][c+1]=mines[r+1][c+1];       
       input[r+1][c]=mines[r+1][c];
      }
      
      else if (c==mines[r].length-1){
       input[r][c-1]=mines[r][c-1];
       input[r-1][c-1]=mines[r-1][c-1];
       input[r-1][c]=mines[r-1][c];
       input[r+1][c-1]=mines[r+1][c-1];       
       input[r+1][c]=mines[r+1][c];
      }
      
      else{
       input[r][c-1]=mines[r][c-1];
       input[r][c+1]=mines[r][c+1];
       input[r-1][c]=mines[r-1][c];
       input[r-1][c-1]=mines[r-1][c-1];
       input[r-1][c+1]=mines[r-1][c+1];
       input[r+1][c]=mines[r+1][c];
       input[r+1][c-1]=mines[r+1][c-1];
       input[r+1][c+1]=mines[r+1][c-1];
      }
//      z=reduce(sr,sc,z);

      }      
  }
  //changes each element stored in the rows and cols array into "O"
     for(int d=0; d<z;d++){
      input[sr[d]][sc[d]]="O";
     }
     
     return input;
     
 }

/*
public static String[][] getBoxes2(String[][]input, String[][]mines, int rows, int cols){
  if(!(input[rows][cols].equals("O"))){
    input[rows][cols]="O";
    for (int r=rows-1; r<rows+2;r++){
      for(int c=cols-1;c<cols+2;c++){
        if (!(mines[r][c].equals("O") || r<0 || c<0 || r>mines.length-1 || c>mines[r].length-1)){
          input[r][c]="O"; 
          getBoxes(input, mines, r, c);
        }
      }
    }
  }
  else {
    input[rows][cols]=mines[rows][cols];
  }
  return input;
}
*/

// the method is called when the user guesses a value
   public static boolean play(int rows, int cols, String[][]input, String[][] mines, boolean ww){
 //returns "M" and ends the game if M is selected
     if (mines[rows][cols].equals("M")){
     input[rows][cols]="M";
     ww=false;
     System.out.println ("You lose");
    }
 //if an empty space is selected, this revelas its surrounding empty spaces
    else if(mines[rows][cols].equals("*")){
     input=getBoxes(input, mines, rows, cols);
    }
 //otherwise, it shows the numbers stored in the grid
    else{
     input[rows][cols]=mines[rows][cols];   
    }
    return ww; 
   }
 
   
//counts the number of mines in a grid
 public static int countMines (String[][] mine){
    int count=0; 
    for (int i=0; i<mine.length;i++){
      for (int k=0; k<mine[i].length; k++){
        if (mine[i][k].equals("M"))
          count++;
      }
    }
    return count; 
  }
   
 // counts the number of stars in a grid
 public static int countStars (String[][] grid){
    int count=0; 
    for (int i=0; i<grid.length;i++){
      for (int k=0; k<grid[i].length; k++){
        if (grid[i][k].equals("*"))
          count++;
      }
    }
    return count; 
  }
 
 // flags the user selected location; unflag if the location is already flagged
 public static boolean flag (int rows, int cols, String[][] input, String[][]mines, String[][]mines2, boolean ww){
      if (input[rows][cols].equals("F")){
       input[rows][cols]="*";
       mines2[rows][cols]="*";
     }
     else if(input[rows][cols].equals("*")){
         input[rows][cols]="F";
         mines2[rows][cols]="F";
     }
     else {
       System.out.println("The space is already occupied");
     }
     // checks the number of mines remaining 
     if (countMines(mines2)==0){
       ww=false; 
     }
     return ww; 
   }
 
 
 //prints out a given 2D array
   public static void printGrid(String[][] grid){
                for (int a=0; a<grid.length;a++){
                for (int b=0; b<grid[a].length;b++){
                  System.out.print (grid[a][b] + "   ");
                }
                System.out.println();
              }               
                System.out.println();
   }
   
 }