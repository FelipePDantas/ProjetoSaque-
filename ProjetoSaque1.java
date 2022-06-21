
import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoSaque1 {
	public static void main(String[] args) {
Scanner sc = new Scanner (System.in);
int Ncartao ;
int opcao ;
double valor ;
int senha;



boolean continuar=true;
do {

	System.out.println("Digite o numero do cartao ");

	Ncartao = sc.nextInt();

	ProjetoSaque c1 = new ProjetoSaque (Ncartao);
	if (c1.validar) {

		System.out.println("-Menu-");
		System.out.println("1-Dados bancarios");
		System.out.println("2-Deposito");
		System.out.println("3-Saque");
		System.out.println("4-Sair");
		
		System.out.print ("opcao :");
		opcao = sc.nextInt();
		if (opcao == 1) {
			c1.DadosBancarios();
		}
		else if (opcao ==2) {
			System.out.println("Digite o valor do desposito");
			valor = sc.nextDouble()	;
			c1.Depositar (valor);
		}
		else if (opcao== 3) {
			System.out.println("digite valor de Saque");
			valor =sc.nextDouble();
			System.out.println("digite a senha");
			senha =sc.nextInt();
			c1.Sacar(valor,senha);
		}else if(opcao >4) {
			System.out.println("opcao invalida");
		}else if (opcao== 4) {
			continuar = false;
		}	
	}
	
	else {
		System.out.println("Cartao invalido");
	}
} while (continuar);
System.out.println("Programa encerrado ");

	}

}
