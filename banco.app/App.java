import java.util.Scanner;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Banco santander = new Banco("0001");
		// C = criar conta E = sair
		while(true) {
			System.out.println("O que deseja fazer? C = criar, E = Sair do programa");
			String op = scanner.nextLine();
			
			if(op.equals("C")) {
				System.out.println("Digite o seu nome: ");
				String name = scanner.nextLine();
				Account account = santander.generateAccount(name);
				santander.insertAccount(account);
				operateAccount(account);
		}
	    else if(op.equals("E")){
	                break;
		}else{
	         System.out.println("Comando inválido, tente novamente!");
	          }
	}
	List<Account>accountList = santander.getAccounts();
	for(Account cc: accountList){
	       System.out.println(cc);
	}
	santander.outPutTotal();
    }
	 static void operateAccount(Account account){
         Scanner scanner = new Scanner(System.in);

         // D = DEPOSITO // S = SAQUE // E = EXIT
         while(true){
             System.out.println("O QUE DESEJA FAZER? D = DEPOSITO, S = SAQUE, E = SAIR DA CONTA");
             String op = scanner.nextLine();

             if(op.equals("D")){
                 System.out.println("Qual o valor que deseja depositar?");
                 double value = scanner.nextDouble();
                 account.deposit(value);
             }else if(op.equals("S")){
                 System.out.println("Qual o valor deseja sacar?");
                 double value = scanner.nextDouble();
                 if (!account.withDraw(value)) {
                     System.out.println("Ops, não foi possivel sacar o valor R$ "+value);
                 }
             }else if (op.equals("E")){
                 break;
             }else{
                 System.out.println("Comando inválido, tente novamente!");
             }
             scanner = new Scanner(System.in);
         }
     }
}
