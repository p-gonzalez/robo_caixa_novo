package br.com.indra.teste;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.indra.DAO.CadastroDAO;
import br.com.indra.bean.CadastrosBean;
import br.com.indra.bin.NomeArqZ;
import br.com.indra.bin.RenomearArq;
import br.com.indra.bin.UtilDate;
import br.com.indra.entity.Cadastros;
import br.com.indra.entity.CallId;

public class Robo {

	private static final String ID_CONTRATADA = "INDRA-FO-2015";
	private WebDriver driver = new InternetExplorerDriver();

	public Robo() {

		driver.manage().window().maximize();
		driver.get("http://10.209.49.100:8080/servlet/acr");
	}

	public void processoNavegacao(String callId) throws AWTException, ParseException, InterruptedException {
		CadastroDAO cadastroDAO = new CadastroDAO();
		RenomearArq ra = new RenomearArq();
		Cadastros cad = new Cadastros();
		CallId call = new CallId();

		String ID_CONTRATADA;

		Robot robot = new Robot();
		if (!driver.getPageSource().contains("Sair") || !driver.getPageSource().contains("ATUALIZAR")) {

			System.out.println(driver.getPageSource());
			System.out.println("INPUT USER:" + driver.findElement(By.id("username")));
			driver.findElement(By.id("username")).sendKeys("Botacr1");
			driver.findElement(By.id("plaint")).sendKeys("Indra@2019");
			driver.findElement(By.id("loginToolbar_LOGINLabel")).click();

			driver.findElement(By.xpath("//select")).click();
			driver.findElement(By.xpath("//option[text()='LayOut_Indra']")).click();
		}

		SimpleDateFormat dataIni = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicio = dataIni.parse("01/08/2019");
		cad.setRecarregarData(dataInicio);

		SimpleDateFormat dataF = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFinal = dataF.parse("01/08/2019");
		cad.setRecarregarData(dataFinal);

		Calendar dtIni = Calendar.getInstance();
		// while (true) {
		Thread.sleep(2000);

		driver.findElement(By.name("param1_startedat")).click();
		driver.findElement(By.name("param1_startedat")).clear();

		driver.findElement(By.name("param2_startedat")).clear();
		driver.findElement(By.name("param2_startedat")).click();
		driver.findElement(By.name("param3_startedat")).clear();

		driver.findElement(By.name("param3_startedat")).click();
		driver.findElement(By.name("param4_startedat")).clear();
		driver.findElement(By.name("param4_startedat")).click();

		Thread.sleep(1000);

		System.out.println("Data consulta ini:" + UtilDate.convertToString(dataInicio, "dd/MM/yyyy"));
		driver.findElement(By.name("param1_startedat")).sendKeys(UtilDate.convertToString(dataInicio, "dd/MM/yyyy"));
		Thread.sleep(1000);
		driver.findElement(By.name("param2_startedat")).sendKeys(UtilDate.convertToString(dataInicio, "00:00:00"));

		System.out.println("Data consulta ini:" + UtilDate.convertToString(dataFinal, "dd/MM/yyyy"));
		Thread.sleep(1000);
		driver.findElement(By.name("param3_startedat")).sendKeys(UtilDate.convertToString(dataFinal, "dd/MM/yyyy"));

		Thread.sleep(1000);
		driver.findElement(By.name("param4_startedat")).sendKeys(UtilDate.convertToString(dataFinal, "23:59:59"));

		Thread.sleep(1000);

		// System.out.println("Consultar...");
		// driver.findElement(By.className("buttonBlue")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.className("buttonBlue")).click();
		//

		// for(int botX = 0; botX < 10; botX++) {
		// robot.keyPress(KeyEvent.VK_TAB);
		// Thread.sleep(1000);
		// }
		//
		
		Select drp = new Select(driver.findElement(By.name("operator_udfs")));
		drp.selectByVisibleText("Qualquer de");

		robot.keyPress(KeyEvent.VK_TAB);
		driver.findElement(By.name("param1_udfs")).clear();

		// inserção do call_id
		driver.findElement(By.name("param1_udfs")).sendKeys(callId);

		driver.findElement(By.className("buttonBlue")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("buttonBlue")).click();

		if (driver.getPageSource().contains("Não há registros correspondentes")
				|| driver.getPageSource().contains(" registros correspondentes")) {

			dataInicio = UtilDate.addDataOuHora(dataInicio, 1, Calendar.SECOND);

			System.out.println("Não há registros correspondentes");

		} else {

			WebElement table = driver.findElement(By.xpath("//*[@id=\"scrollresults\"]/table"));

			List<WebElement> linhas = table.findElements(By.tagName("tr"));

			int col = 0;

			ArrayList<String> call_id = new ArrayList<String>();

			WebElement chk = null;

			for (WebElement linha : linhas) {
				Cadastros cadastros = new Cadastros();
				List<WebElement> colunas = linha.findElements(By.tagName("td"));

				if (linha.getAttribute("class").contains("formRowSessionGraphic")) {
					try {
						chk = linha.findElement(By.tagName("input"));
						if (chk.getAttribute("name").contains("selallornone")) {
							continue;
						}
					} catch (Exception e) {
					}

					if (chk != null && !chk.isSelected()) {

						chk.click();

						// mapeamento da janela para exportar
						driver.findElement(By.xpath("//img[@title='Exportar']")).click();
						Thread.sleep(10000);

						// file of types
						robot.keyPress(KeyEvent.VK_TAB);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(1000);
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(1000);
						// fim file of types

						// chegar ate a seleção do arquivo
						robot.keyPress(KeyEvent.VK_TAB);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_TAB);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_TAB);
						Thread.sleep(500);

						// alteração aqui / c:/ligações
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_UP);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_UP);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_UP);

						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(1000);

						// fir alteração

						// tab 6 vezes

						for (int botX = 0; botX < 6; botX++) {
							robot.keyPress(KeyEvent.VK_TAB);
							Thread.sleep(1000);
						}

						robot.keyPress(KeyEvent.VK_L);
						Thread.sleep(2000);

						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(1000);

						// NAVEGAR NAS PASTAS - /ligacoes/bot1 a 12
						for (int botX = 0; botX < 1; botX++) {
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(1000);
						}

						 //exlusivo para o bot 1
						//robot.keyPress(KeyEvent.VK_UP);
						//Thread.sleep(1000);
						

						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(1000);

						for (int botX = 0; botX < 3; botX++) {
							robot.keyPress(KeyEvent.VK_TAB);
							Thread.sleep(1000);
						}

						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(2000);

						// VerificarTamanhoDoArq.verficarTamanhoDoArq();

						// Metodo para renomear o arquivo após salvar

						// fim do metodo para renomear o arquivo

						// fechar a janela filha após terminar o download

						String janelaprincipal = driver.getWindowHandle();

						Set<String> s1 = driver.getWindowHandles();
						Iterator<String> i1 = s1.iterator();

						while (i1.hasNext()) {
							String janelafilha = i1.next();

							if (!janelaprincipal.equalsIgnoreCase(janelafilha)) {

								driver.switchTo().window(janelafilha);

								driver.close();
							}
						}

						driver.switchTo().window(janelaprincipal);

					}
					continue;
				}

				CadastrosBean b = new CadastrosBean();

				for (WebElement coluna : colunas) {

					if (coluna.getAttribute("class").contains("tableHeaderLight")) {
						continue;
					}
					switch (col) {
					case 0:
						// cadastros.setInicioContato(UtilDate.convertToDate(coluna.getText(),
						// "yyyy/MM/dd HH:mm:ss"));
						cadastros.setInicioContato(UtilDate.convertToDate(coluna.getText(), "dd/MM/yy HH:mm:ss"));

						break;
					case 1:
						cadastros.setProprietario(coluna.getText());
						break;
					case 2:
						cadastros.setInterlocutores(coluna.getText());
						break;
					case 3:
						cadastros.setServico(coluna.getText());
						break;
					case 4:
						cadastros.setHabilidades(coluna.getText());
						break;
					case 5:
						cadastros.setUdf(coluna.getText());
						setDadosFromUdf(cadastros);
						break;
					case 6:
						cadastros.setDuracao1(coluna.getText());
						break;
					case 7:
						cadastros.setDuracaoTotal(coluna.getText());
						
						//cadastros.setTempoAtendimento(coluna.getText());

						 cadastros.setTempoAtend(coluna.getText().replace(":",
						","));
						
						cadastros.setTempoAtend(UtilDate.convertMinutoEmSegundos(coluna.getText()));
						break;
					case 8:
						call_id.add(coluna.getText());

						cadastros.setCallId(coluna.getText());
						break;

					default:
						break;
					}
					col++;
					

				}

				if (cadastros.getCallId() != null) {
					// cadastros.setDataHoraProcessamento(UtilDate.convertToDate(cadastros.getInicioContato(),
					// "dd/MM/yy HH:mm:ss"));
					cadastros.setNomeArquivo(getNomePadraoArquivo(cadastros));
					cadastroDAO.salvar(cadastros);
					// dataInicio = cadastros.getDataHoraProcessamento();

					System.out.println(UtilDate.convertToString(dataInicio, "dd/MM/yyyy"));

					Thread.sleep(5000);
					//EnderecoBot en = new EnderecoBot();
					//NomeArqZ na = new NomeArqZ();

					RenomearArq.renomearArquivo("C:\\ligacoes\\bot2",
							getNomePadraoArquivo(cadastros), "c:\\ligacoesDefinitivas\\bot12");
							//getNomePadraoArquivo(cadastros), "Z:\\2019\\Agosto\\01\\00-00");
					
					//RenomearArq.renomearArquivo(en.getBot03(), getNomePadraoArquivo(cadastros), na.getJan3());

					// RenomearArq.renomearArquivo(en.getBot03(),
					// getNomePadraoArquivo(cadastros),
					// RenomearArq.getPath(cadastros.getInicioContato()));
					//
					// RenomearArq.renomearArquivo(en.getBot01(),
					// getNomePadraoArquivo(cadastros),
					// "Z:\\2019\\Abril\\01\\01-00");
					//
					Thread.sleep(5000);

					// String narq = getNomePadraoArquivo(cadastros);
					// cadastros.setNomeArquivo("teste");
					// System.out.println(narq);
					// cadastros.setNomeArquivo(getNomePadraoArquivo(cadastros));

					// cadastroDAO.atualizarNomeArquivo(getNomePadraoArquivo(cadastros),
					// cadastros);

				}

				if (col >= 8) {
					col = 0;

				}

				if (chk != null && chk.isSelected()) {
					chk.click();
				}

			}
		}

	}

	// }

	private static void setDadosFromUdf(Cadastros cadastros) {
		if (cadastros.getUdf() != null && !cadastros.getUdf().isEmpty()) {
			String[] dados = cadastros.getUdf().split("\\|");
			cadastros.setIdChamado(dados[0].replaceAll("[^\\p{ASCII}]", "").replace("personalizado:", ""));
			cadastros.setNumTel(dados[1]);// numero do telefone do chamador
			cadastros.setCfpCnpj(dados[2]); // cpf titular
			cadastros.setNomeTitular(dados[3]); // nome do titular
			cadastros.setIdOperador(dados[8]); // ip proprietario

		}

	}

	private static void nomeArquivo(Cadastros cadastros) {

		String nomeDoArquivo = getNomePadraoArquivo(cadastros);
		cadastros.setNomeArquivo(nomeDoArquivo);

	}

	public static String getNomePadraoArquivo(Cadastros cadastros) {
		StringBuffer nomePadrao = new StringBuffer();
		// String nomePadrao = "";
		if (cadastros.getCfpCnpj() == null || cadastros.getCfpCnpj().isEmpty()) {
			nomePadrao.append("0000000000000000");
		} else {
			if (cadastros.getCfpCnpj().trim().length() < 14) {
				nomePadrao.append("00000").append(cadastros.getCfpCnpj());
			} else {
				if (cadastros.getCfpCnpj().trim().length() >= 14) {
					nomePadrao.append("00").append(cadastros.getCfpCnpj());
				}

			}
		}

		if (cadastros.getNumTel() == null || cadastros.getNumTel().isEmpty()) {
			nomePadrao.append("00000000000");
		} else {
			nomePadrao.append(cadastros.getNumTel());
		}

		nomePadrao.append(
				/*
				 * UtilDate.convertToDate(cadastros.getInicioContato(),
				 * UtilDate.PATTERN_DD_MM_YY_HH_MM_SS),
				 * UtilDate.PATTERN_YYYYMMDDHH_MMSS));
				 */

				UtilDate.convertToString(cadastros.getInicioContato(), UtilDate.PATTERN_YYYYMMDDHH_MMSS));

		// nomePadrao.append(cadastros.getDuracao_total().replace(":", ""));

		if (cadastros.getProprietario() == null || cadastros.getProprietario().isEmpty()) {
			nomePadrao.append("00000000");
		} else {
			if (cadastros.getProprietario().trim().length() < 8) {
				// nomePadrao.append(cadastros.getProprietario());
				nomePadrao.append("000").append(cadastros.getProprietario());
			} else {
				nomePadrao.append(cadastros.getProprietario());

			}

		}
		nomePadrao.append(ID_CONTRATADA);

		if (cadastros.getCallId() == null || cadastros.getCallId().isEmpty()) {
			nomePadrao.append("00000000000000000000");
		} else {
			nomePadrao.append(cadastros.getCallId());
		}

		return nomePadrao.toString();
	}

}
