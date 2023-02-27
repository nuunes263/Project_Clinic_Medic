import java.util.Scanner;

public class CPFExpception extends Exception{
  public String verificaCpf(){
    boolean correct = false;
    Scanner a = new Scanner(System.in);
    String cpf = "";      
  
    do {
      int total1 = 0;
      int total2 = 0;
      System.out.print("digite o cpf do paciente: "); 
      cpf = a.nextLine();   
      int cont1 = 10;
      for(int i = 0;i<9;i++){
        String num = cpf.substring(i, i+1);
        total1 += Integer.parseInt(num)*cont1;
        cont1--;
      }
    
      int cont2 = 11;
      for(int i = 0;i<10;i++){
        String num = cpf.substring(i, i+1);
        total2 += Integer.parseInt(num)*cont2;
        cont2--;
      }
      
      int dig1 = 11 - (total1 % 11);
      int dig2 = 11 - (total2 % 11);

      try{
        if(dig1 == Integer.parseInt(cpf.substring(9, 10)) && dig2 == Integer.parseInt(cpf.substring(10, 11))){
          System.out.println("\nCpf valido !!");
          correct = true;
        } else {
          throw new Exception("\nCPF invalido, tente novamente");
        }
      } 
      catch (Exception e) {
        System.out.print("\nCPF invalido, tente novamente\n");
      }
    } while (!correct);   
    return cpf;
  }
}