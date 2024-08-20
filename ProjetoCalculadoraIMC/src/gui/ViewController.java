package gui;

import gui.CalculoIMC.CalculoImc;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ViewController {

	@FXML
	private TextField TextInformePeso;
	@FXML
	private TextField TextInformeAltura;

	@FXML
	private Button BtCalcularImc;
	@FXML
	private Button BtLimpaTela;

	@FXML
	private RadioButton RadioBtSexoMasculino;
	@FXML
	private RadioButton RadioBtSexoFeminino;

	private ToggleGroup toggleGroupSexo;

	@FXML
	private Label LabelMostraIMC;
	@FXML
	private Label LabelMostraPesoIdeal;
	@FXML
	private Label LabelMostraPesoIdealAjustado;
	@FXML
	private Label LabelMostraSituacao;
	@FXML
	private Label LabelMostraDivergencia;
	@FXML
	private Label LabelInformarErro;

	private CalculoImc Imc = new CalculoImc();

	public void initialize() {
		toggleGroupSexo = new ToggleGroup();
		RadioBtSexoMasculino.setToggleGroup(toggleGroupSexo);
		RadioBtSexoFeminino.setToggleGroup(toggleGroupSexo);
	}

	@FXML
	private void onBtCalcularImcAction() {
		try {

			double peso = Double.parseDouble(TextInformePeso.getText());
			double altura = Double.parseDouble(TextInformeAltura.getText());

			RadioButton selectedRadioButton = (RadioButton) toggleGroupSexo.getSelectedToggle();

			if (selectedRadioButton != null) {

				if (RadioBtSexoFeminino.isSelected()) {

					double pesoIdealFeminino = Imc.CalculoPesoIdealFeminino(altura);
					double paraEncontrarImc = Imc.CalculoParaEncontrarImc(peso, altura);

					LabelMostraIMC.setText(String.format(" %.1f ", Imc.CalculoParaEncontrarImc(peso, altura)));

					LabelMostraPesoIdeal.setText(String.format("%.1f", pesoIdealFeminino));

					LabelMostraPesoIdealAjustado
							.setText(String.format("%.1f", Imc.CalculoPesoIdealAjustado(peso, pesoIdealFeminino)));

					LabelMostraSituacao.setText(Imc.InformarResultadoTitulo(paraEncontrarImc));

					LabelMostraDivergencia.setText(Imc.InformarResultadoDivergencia(paraEncontrarImc));
				}

				if (RadioBtSexoMasculino.isSelected()) {

					double pesoIdealMasculino = Imc.CalculoPesoIdealMasculino(altura);
					double paraEncontrarImc = Imc.CalculoParaEncontrarImc(peso, altura);

					LabelMostraIMC.setText(String.format(" %.1f ", Imc.CalculoParaEncontrarImc(peso, altura)));

					LabelMostraPesoIdeal.setText(String.format("%.1f", pesoIdealMasculino));

					LabelMostraPesoIdealAjustado
							.setText(String.format("%.1f", Imc.CalculoPesoIdealAjustado(peso, pesoIdealMasculino)));

					LabelMostraSituacao.setText(Imc.InformarResultadoTitulo(paraEncontrarImc));

					LabelMostraDivergencia.setText(Imc.InformarResultadoDivergencia(paraEncontrarImc));
				}

			}
			else {
				LabelInformarErro.setText("Informe o Sexo!!");
			}

		} catch (NumberFormatException e) {
			Alerts.showAlert("Erro", "Letras entre os números ! ", null, AlertType.ERROR);
		}
	}

	@FXML
	public void onBtLimparAction() {

		TextInformePeso.clear();
		TextInformeAltura.clear();

		LabelMostraIMC.setText(" ");
		LabelMostraPesoIdeal.setText(" ");
		LabelMostraPesoIdealAjustado.setText(" ");
		LabelMostraSituacao.setText(" ");
		LabelMostraDivergencia.setText(" ");
		LabelInformarErro.setText(" ");

		RadioBtSexoMasculino.setSelected(false);
		RadioBtSexoFeminino.setSelected(false);

	}

}
