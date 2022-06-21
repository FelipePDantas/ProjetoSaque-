

import java.util.ArrayList;

public class ProjetoSaque {
	 UsuariosCRUD user = new UsuariosCRUD ();
	
	Usuario DataUser ;
	boolean validar = false;
	 public  ProjetoSaque (int NCartao) {
		 
		 ArrayList<Usuario> dados =user.listausuarios();
		
		for (int i =0; i<dados.size(); i++) {
			if (NCartao == dados.get(i).Ncartao) {
				System.out.println("user: "+dados.get(i).Nome);
				DataUser = dados.get(i);
				validar = true;
				System.out.println("Usuario valido");
				
			}
			
		}
} 
	 public  void DadosBancarios () {
		if (validar) {
			 System.out.println("Dados Bancarios");
			 System.out.println("numero: "+DataUser.Ncartao);
			 System.out.println("Titular: "+ DataUser.Nome);
			 System.out.println("Saldo: "+ DataUser.Saldo);
			 System.out.println("Fim da Operação");
		}
	 }
	 public void Depositar(double Valor) {
		 if (validar) {
		 System.out.println("");
		 System.out.println(" Deposito Realizado ");
		 System.out.println("Saldo anterrior: "+DataUser.Saldo);
		 DataUser.Saldo +=  Valor;
		 System.out.println("Saldo posterior: "+DataUser.Saldo);
		 System.out.println("Fim do deposito");
		 System.out.println();
		 }
	 }
	 public void Sacar (double Valor, int senha)  {
		 if(validar) {
				System.out.println("");
				System.out.println("Realizando Saque: ");
				System.out.println("Saldo anterior :"+DataUser.Saldo);
				
				 if(DataUser.senha == senha) {
					 if (Valor <= DataUser.Saldo) {
						 DataUser.Saldo -=Valor;
					 System.out.println("saldo posterioro: "+DataUser.Saldo);
					 }
					 else {
						 System.out.println("Saldo insuficiente");
					 }
				 }else {
					 System.out.println("senha errada");
				 }
				 System.out.println("Fim de Saque");
	
		 
		 
		
		 }
	 
	
	 
	 
	 }
}