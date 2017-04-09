public class Test{
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
  
  
  public static String[][] makeMines(int n){
    int numMines= (int) (2); 
    String [][] mines= makeGrid(n); 
    int [] rows= randomGenerator(numMines, n); 
    int [] cols = randomGenerator(numMines, n);
    for (int i =0; i<numMines; i++){
      mines[rows[i]][cols[i]]= "M"; 
    }
    return mines;
  }

  public static String[][] getNums (String[][]grid){
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
  
 public static String[][] openNear (String arr[][], int c, int r){
     while (c<9 && arr[c][r].equals("*")){
     while (r<9 && arr[c][r].equals("*")){
       if (arr[c][r].equals("*")){
         arr[c][r] = "O";
         r++;
       }
       else if (arr[c][r].equals("*")){
         arr[c][r] = "0";
         r--;
       }
       c--;
     }
     
     while (c<9 && arr[c][r].equals("*")){
       while (r<9 && arr[c][r].equals("*")){
         if (arr[c][r].equals("*")){
           arr[c][r] = "O";
           r++;
         }
         else if (arr[c][r].equals("*")){
           arr[c][r] = "0";
           r--;
         }
         c--;
       }
     }
   }
   return arr;
 }
  
  
  public static void main (String[] args){

    String [][] grid1 = makeMines (9);
    getNums(grid1);
    grid1=openNear(grid1, 4,4);
    for (int a=0; a<grid1.length;a++){
      for (int b=0; b<grid1[a].length;b++){
        System.out.print (grid1[a][b] + "   ");
      }
      System.out.println();
    }
    System.out.println(countMines(grid1));
    
    
 
}

}