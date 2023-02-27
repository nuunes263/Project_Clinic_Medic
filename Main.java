import java.util.Scanner;

//feito por Tiago Nunes(32230680) e Pedro Bacic (42037913)
//feito por Tiago Nunes(32230680) e Pedro Bacic (42037913)
//feito por Tiago Nunes(32230680) e Pedro Bacic (42037913)

class Main {
  public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);
    CPFExpception c = new CPFExpception();  
    int opcao = 0;
    Paciente [] vetPaciente = new Paciente[100];
    
    System.out.println(" \n ----- menu - cadastrar pacientes ----- ");
    do { 
      System.out.println("");
      System.out.println("1. cadastrar paciente");
      System.out.println("2. lista de pacientes");
      System.out.println("3. buscar cpf");
      System.out.println("4. apagar paciente");
      System.out.println("5. encerrar\n");
      System.out.print("opcao escolhida: ");
      
      opcao = entrada.nextInt();
      System.out.println("");
      switch(opcao){
        case 1:
          cadastrarPaciente(vetPaciente, c);
          break;
        case 2:
          listaPaciente(vetPaciente);
          break;
        case 3:
          buscarCpf(vetPaciente);
          break;
        case 4:
          apagarPaciente(vetPaciente);
          break;         
      }     
    } while(opcao != 5);
  }
    
  public static void cadastrarPaciente(Paciente [] vetPaciente, CPFExpception c){
    Scanner a = new Scanner(System.in);
    String cpf = c.verificaCpf();
    
    System.out.print("\no paciente possui plano de saude? \ndigite (s) para sim e (n) para nao: ");
    char resposta = a.next().charAt(0); 
    System.out.println("");
    boolean plano = true;
    int num = 0; 
    if (resposta == 'n'){
      plano = false;
      Paciente novoPaciente = new Paciente(plano, cpf);
      vetPaciente[novoPaciente.retornaContador()] = novoPaciente;
      novoPaciente.somarContador();
      
    }
    else{
      System.out.print("digite o numero da carteirinha: ");
      num = a.nextInt();
      Paciente novoPaciente = new Paciente(plano, num, cpf);
      vetPaciente[novoPaciente.retornaContador()] = novoPaciente;
      novoPaciente.somarContador();      
    }  
  }
  
  public static void listaPaciente(Paciente [] vetPaciente){
    
    System.out.println("---lista de pacientes---");
    for(int i = 0; i<vetPaciente[0].retornaContador(); i++){    
      if(vetPaciente[i].cpf != null){
      System.out.printf("\n- Paciente %d:\ncpf: %s\n", i+1,vetPaciente[i].cpf);
      
        if (vetPaciente[i].planoDeSaude == false){
          System.out.println("nao possui carteirinha");
        }
        else{
          System.out.println("numero da carteirinha: " + vetPaciente[i].numeroCarteirinha);
        }
      }
    }
  }
    
  public static void buscarCpf(Paciente[]vetPaciente){
    Scanner b = new Scanner(System.in);
    System.out.print("digite o cpf que deseja buscar: ");
    String busca = b.next();
    for(int i=0; i<vetPaciente[0].retornaContador();i++){
      if(vetPaciente[i].cpf.equals(busca)){
        System.out.printf("\n- paciente %d: ",i+1);
        System.out.printf("\ncpf: %s\n",vetPaciente[i].cpf);
      }
    }
  }   
  
  public static void apagarPaciente(Paciente[]vetPaciente){
    Scanner c = new Scanner(System.in);
    System.out.println("---lista de pacientes---\n");  
    for(int i = 0; i<vetPaciente[0].retornaContador(); i++){
      if(vetPaciente[i].cpf != null){
      System.out.printf("- Paciente %d\n cpf: %s\n", i+1,vetPaciente[i].cpf);
        if (vetPaciente[i].planoDeSaude == false){
        System.out.println("nao possui carteirinha\n");
        }
        else{
          System.out.println("numero da carteirinha: " + vetPaciente[i].numeroCarteirinha);
          System.out.println("");
        }
      }
    }
    System.out.print("\ndigite o numero do paciente que deseja apagar: ");
    int num = c.nextInt();
    vetPaciente[num-1].cpf = null;
    System.out.println("\npaciente deletado");     
  }
}