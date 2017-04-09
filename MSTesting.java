import java.util.Scanner;
public class MSTesting extends Mindsweeper{



 public static void main (String[] args){
     int n=10; 
     
      String[][]grid2 = makeGrid(n);
      String[][]grid1 = makeGrid(n);
     
     printGrid(grid2);
     System.out.println("Enter G to guess a box; Enter F to flag/unflag a box; Enter Q to place/unplace a question mark" +
                        "\n ------------------please be patient to wait for the new grid to print out after an interaction as it may take up to 10 seconds-----------------" + 
                        "\n WINNING CONDITION: All mines must be flagged and all boxes must be unrevealed");
     
      boolean cont= true; 
      boolean cont1=true;
      int cont2=0;
      int rr=0;
      int cc=0;
      int count=0;
      String type=" "; 
      String[][] grid3=grid1;

      
      while (cont==true){
       Scanner kb= new Scanner(System.in);
       System.out.println("Enter G to guess a box; Enter F to flag/unflag a box; Enter Q to place/unplace a question mark");
       type=kb.nextLine();
       System.out.println("Row?");
       rr=kb.nextInt();
       System.out.println("Column?");
       cc=kb.nextInt();
       
       // generates the mind after first user-input so that the first user-input would not be a mine 
       if (count==0){
           grid1=makeMines(n);
           grid1[0][0]="M";
           grid1[rr][cc]="*";
            nums(grid1);
       }
       
       
       if (type.equals("G")){
         cont= play(rr,cc,grid2,grid1,cont);
       }
       
       //enter Q to question or unquestion a box
       else if (type.equals("Q")){
         if (grid2[rr][cc].equals("*")){
           grid2[rr][cc]="?";
         }
         else if(grid2[rr][cc].equals("?")){
           grid2[rr][cc]="*"; 
         }    
       }
       
       else {
         cont1= flag(rr, cc, grid2, grid1, grid3, cont);
       }
         
       cont2=countStars(grid2);
       
       
       if (cont1==false && cont2==0){
         System.out.println("You win!");
         cont=false; 
       }
       
//         System.out.println(cont2);
//         System.out.println(cont);
       
         printGrid(grid1);
         printGrid(grid2);
       
         count++;
      }
   }

}