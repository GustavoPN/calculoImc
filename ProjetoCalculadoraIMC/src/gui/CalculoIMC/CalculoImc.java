package gui.CalculoIMC;

public class CalculoImc {
	
	public double CalculoParaEncontrarImc(double primeiroValor, double segundoValor) {
		
		double resultadoImc = segundoValor * segundoValor;
		
		resultadoImc = primeiroValor / resultadoImc;
		
		return resultadoImc;
		
	}
	
	public double CalculoPesoIdealMasculino(double valorAltura) {
	
		valorAltura = valorAltura * 100;
		
		double pesoIdeal = valorAltura - 152.4 ;
		
		pesoIdeal = 52 + (0.75 * pesoIdeal);
		
		return pesoIdeal;
		
	}
	
	public double CalculoPesoIdealFeminino(double valorAltura) {
		
		valorAltura = valorAltura * 100;
		
		double pesoIdeal = valorAltura - 152.4;
		
		pesoIdeal = 52 + (0.67 * pesoIdeal);
		
		return pesoIdeal;
		
	}
	
	public double CalculoPesoIdealAjustado(double pesoAtual, double pesoIdeal) {
		
		double pesoIdealajustado = ((pesoAtual - pesoIdeal) * 0.25) + pesoIdeal;
		
		return pesoIdealajustado;
	}
	
	public String InformarResultadoTitulo(double valor1) {

		if (valor1 <= 17) {
			return("Muito abaixo do peso\n Magreza Grave");
		} else if (valor1 >= 17 && valor1 <= 18.5) {
			return("Abaixo do peso\n Magreza Leve");
		} else if (valor1 >= 18.5 && valor1 <= 24.9) {
			return("Peso normal\n Eutrófico");
		} else if (valor1 >= 25 && valor1 <= 29.9) {
			return("Acima do peso\n Sobrepeso");
		} else if (valor1 >= 30 && valor1 <= 34.9) {
			return("Obesidade I\n ");
		} else if (valor1 >= 35 && valor1 <= 39.9) {
			return("Obesidade II\n Obesidade Severa");
		} else {
			return("Obesidade III\n Obesidade Mórbina");
		}

	}
	
	public String InformarResultadoDivergencia(double valor1) {

		if (valor1 <= 17) {
			return("Insuficiência Cardíaca\n Anemia Grave\n Enfraquecimento do Sist. Imune");
		} else if (valor1 >= 17 && valor1 <= 18.5) {
			return("Problemas de saúde\n ligados a desnutrição");
		} else if (valor1 >= 18.5 && valor1 <= 24.9) {
			return("Saudável");
		} else if (valor1 >= 25 && valor1 <= 29.9) {
			return("Fadiga\n Varizes\n Má Circulação");
		} else if (valor1 >= 30 && valor1 <= 34.9) {
			return("Diabétes\n Infarto\n Angina\n Aterosclerose");
		} else if (valor1 >= 35 && valor1 <= 39.9) {
			return("Falta de Ar\n Apneia do Sono");
		} else {
			return("Refluxo\n Infarto\n Avc\n Dificuldade para Locomoção");
		}

	}

}
