import java.util.*; 

public class Testing{//Ash is worst girl
  
    public static String [][] makeGrid(int n){
      String [][] plate= new String [n][n]; 
      for (int i=0; i<plate.length; i++){
        for(int k=0; k<plate[i].length; k++){
          plate[i][k]= "*"; 
        }
      }
      return plate; 
  }
    
    
    public static int[] randomGenerator(int range, int n){
      int [] collection = new int[range];
      for (int i=0; i<collection.length;i++){
        collection[i]= (int)(Math.random()*(n));
      }
      return collection;  
  }
  
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
   

 public static String[][] getBoxes(String[][] input, String[][]mines, int rows, int cols){
  int []sr=new int[100000000];
  int []sc=new int[100000000];
  sr[0]=rows;
  sc[0]=cols; 
  int z=1;
     for(int a=0; a<8000000; a++)
      z=getLocation(sr[a], sc[a], input, mines,z, sr, sc);
     
     int r=0;
     int c=0;

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
      }      

     for(int d=0; d<z;d++){
      input[sr[d]][sc[d]]="O";
     }
     

     return input;
 }

 
 public static String[][] getBoxes2(String[][]input, String[][]mines, int rows, int cols){
  if(!(input[rows][cols].equals("O") && mines[rows][cols].equals("O"))){
    input[rows][cols]="O";
    for (int r=rows-1; r<rows+2;r++){
      for(int c=cols-1;c<cols+2;c++){
        if (!((rows==r && cols==c) || r<0 || c<0 || r>mines.length-1 || c>mines[r].length-1)){
     //     input[r][c]="O"; 
          getBoxes2(input, mines, r, c);
        }
      }
    }
  }
    else{
    input[rows][cols]=mines[rows][cols];
  }
 
    
 //   else if ((input[rows][cols].equals("1")) || (input[rows][cols].equals("2")) || (input[rows][cols].equals("3")) || (input[rows][cols].equals("4")) || (input[rows][cols].equals("5")) || (input[rows][cols].equals("6")) || (input[rows][cols].equals("7"))|| (input[rows][cols].equals("8"))){
  //  input[rows][cols]=mines[rows][cols];
 // }
  return input;
}

   public static boolean play(int rows, int cols, String[][]input, String[][] mines, boolean ww){
    if (mines[rows][cols].equals("M")){
      
     input[rows][cols].equals("M");
     ww=false;
     System.out.println ("You lose");
    }
    
    else if(mines[rows][cols].equals("*")){
     input=getBoxes2(input, mines, rows, cols);
    }
    
    else{
     input[rows][cols]=mines[rows][cols];   
    }
    return ww; 
   }
 
   
     public static int countMines (String mine[][]){
    int count=0; 
    for (int i=0; i<mine.length;i++){
      for (int k=0; k<mine[i].length; k++){
        if (mine[i][k].equals("M"))
          count++;
      }
    }
    return count; 
  }
   
   
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
       System.out.println("Invalid input");
     }
   
     if (countMines(mines2)==0){
       ww=false; 
       System.out.println("You win");
     }
     return ww; 
   }
 
 

   
 
   ///-----------------------------------------------------------------------
   
   public static void main (String[] args){
     int n=10; 
     
      String[][]grid2 = makeGrid(n);
      String[][]grid1 = makeGrid(n);
     
    int[] rows = new int[] {1};
    int[] cols = new int[] {2};

     
     
       
       
     for (int i=0; i<rows.length;i++){
       grid1[rows[i]][cols[i]]="M";
     }
     
     
 //    grid1=makeMines(n);
     
     
     nums(grid1);
    
      boolean cont= true; 
      int rr=0;
      int cc=0;
      int count=0;
      String type=" "; 
      String[][] grid3=grid1;
      
      while (cont==true){
       Scanner kb= new Scanner(System.in);
       type=kb.nextLine();
       rr=kb.nextInt();
       cc=kb.nextInt();

       
      
       
       if (type.equals("G")){
         cont= play(rr,cc,grid2,grid1,cont);
       }
       
       else {
         cont= flag(rr, cc, grid2, grid1, grid3, cont);
       }
         
         System.out.println(cont);
       
       
            for (int a=0; a<grid1.length;a++){
                for (int b=0; b<grid1[a].length;b++){
                  System.out.print (grid1[a][b] + "  ");
                }
                System.out.println();
              }
                
                System.out.println();
                
                for (int a=0; a<grid2.length;a++){
                for (int b=0; b<grid2[a].length;b++){
                  System.out.print (grid2[a][b] + "  ");
                }
                System.out.println();
              }
              

      }
      

     

     
     

       
   }










 }