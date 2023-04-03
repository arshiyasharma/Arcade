import java.util.Scanner;
public abstract class arcade
{
    abstract void rules();
    abstract boolean game();
   
    String name;
    void welcome()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name - ");
        name = sc.nextLine();
    }
   
    void result(boolean ans)
    {
        System.out.print("\n\n"+(ans==false ? "Gotcha, "+name+". You lost!" : "Congratulations, "+name+". You won!!"));;
    }
}