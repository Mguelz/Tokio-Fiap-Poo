package Aulas.poo;

import java.sql.Date;

public abstract class Conta {

	protected int numeroConta, agencia;
	protected String senha;
	protected Date dataAbertura;
	protected double saldo;
	protected Cliente cliente; // composição // todos os dados do cliente esta nesta "variavel/objeto"

	// construtor
	public Conta(Cliente cliente, int numeroConta, int agencia, String senha) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.senha = senha;
		this.dataAbertura = new Date(System.currentTimeMillis()); // retorna data do sistema operacional
		System.out.println("Conta criada");
		System.out.println("Data de abertura: " + this.dataAbertura);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean sacar(double valor) {
		if (valor > 0) { // nao pode sacar 0 reais
			if (this.saldo >= valor) {
				this.saldo -= valor;
				return true;
			}
		}
		return false;
	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
	}

	public void transferir(Conta conta, double valor) {
		boolean teste = this.sacar(valor);

		if (valor > 0) {
			if (teste == true) { // verificar se tem dinheiro na conta
				this.sacar(valor);
			}
		}
		conta.depositar(valor);
	}

	public abstract void exibirSaldo(); // método abstrato / a classe filha terá que compor este método

//	@Override
//	public String toString() {
//		return "saldo da conta " + saldo;
//	}

}

/*
 * Exemplo de um carro
 * 
 * composição é obrigatória rx: rodas, motor, escapamento
 * 
 * associação opcional ex: multimídia, ar-condicionado
 * 
 * Abstract: proibe a istancia da classe
 */