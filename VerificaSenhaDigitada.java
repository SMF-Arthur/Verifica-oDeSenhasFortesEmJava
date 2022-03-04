
import java.util.Scanner;

public class VerificaSenhaDigitada{

    public static void main(String[] args){
        
        Scanner ler = new Scanner(System.in);
        
        String[] digitos = {"0","1","2","3","4","5","6","7","8","9"};
        String[] maiusculos = {"A","B","C","Ç","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","W","Z"};
        String[] minusculo = {"a","b","c","ç","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","w","z"};
        String[] caracteresEspeciais = {"!","@","#","$","%","^","&","*","(",")","-","+"};
        
        int[] confirmacao = new int [4]; 
                
        String nome = "";
        String senha = "";
        boolean continuar = true;        
        
        System.out.println("Digite Seu Nome : ");
        nome = ler.nextLine();
        
        while(continuar){                      
            //int i = 0;
            
            System.out.println("\nDigite Sua Senha : ");
            senha = ler.nextLine();
            
            if(senha.length() < 6){
                int diferenca = 6 - senha.length();
                System.out.println("Falta " + diferenca + " Caracteres para completar a senha mínima!" );                              
                
            }
            else{
                
                confirmacao[0] = verificaSenha(senha, digitos);
                confirmacao[1] = verificaSenha(senha, maiusculos);
                confirmacao[2] = verificaSenha(senha, minusculo);
                confirmacao[3] = verificaSenha(senha, caracteresEspeciais);
                
                if(confirmacao[0] == 0){
                    System.out.println("Acrescente algum número na sua Senha EX: 1, 2, 3 ....");
                }
                if(confirmacao[1] == 0){
                    System.out.println("Acrescente algum caractere Maiusculo na sua Senha EX: A, B, C ....");
                }
                if(confirmacao[2] == 0){
                    System.out.println("Acrescente algum caractere Minusculo na sua Senha EX: a, b, c ....");
                }
                if(confirmacao[3] == 0){
                    System.out.println("Acrescente algum caractere especial da lista : !@#$%^&*()-+");
                }
                if(confirmacao[0] == 1 && confirmacao[1] == 1 && confirmacao[2] == 1 && confirmacao[3] == 1){
                    System.out.println("Senha Segura!!!!!!");
                    continuar = false;
                }                
            }            
            
         }        
    }
        
    public static int verificaSenha(String senha, String[] sequenciaCaracter){
      
        int valor = 0;
        
        for(int varredura = 0; varredura < sequenciaCaracter.length; varredura++){
            
            if(senha.contains(sequenciaCaracter[varredura])){
               valor = 1; 
            }            
        }
        
        return valor;
    } 
    
}
