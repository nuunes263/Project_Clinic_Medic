public class Paciente{
  boolean planoDeSaude;
  int numeroCarteirinha;
  String cpf;
  static int contador = 0;
  
  public Paciente(boolean planoDeSaude, int numeroCarteirinha,String cpf){
    this.planoDeSaude = planoDeSaude;
    this.numeroCarteirinha = numeroCarteirinha;
    this.cpf = cpf;
    
  }
  public Paciente(boolean planoDeSaude, String cpf){
    this.planoDeSaude = planoDeSaude;
    this.cpf = cpf;
    this.numeroCarteirinha = 0;
   } 
  
  public void somarContador(){
    Paciente.contador++;
  }
  
  public int retornaContador(){
    return Paciente.contador;
  }

  public void subtrairContador(){
    Paciente.contador--;
  }
}