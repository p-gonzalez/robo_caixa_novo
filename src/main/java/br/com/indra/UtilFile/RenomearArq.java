package br.com.indra.UtilFile;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RenomearArq {
	public static final Logger logger = LogManager.getLogger(RenomearArq.class.getName());
	public static boolean renomearArquivo(String pathOrigem, String nomeNovoArquivo, String pathRaiz) {
		String novoDiretorio;
		boolean isExiste = false;
        try {
        	logger.info("Classe: RenomearArq, Método:renomearArquivo, Mensagem: Efetuando a Renomeação do Arquivo ");
        	File novoArq = new File(pathOrigem + File.separator + nomeNovoArquivo +".aar");
        	
        	if(novoArq.exists()){
        		novoArq.delete();
        		logger.info("Classe: RenomearArq, Método:renomearArquivo, Mensagem: Arquivo Existe");
        	}
        	
        	File f = new File(pathOrigem); 
    		File[] files = f.listFiles (new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.getName().toLowerCase().endsWith(".aar");
                } 
            });
    		
    		for (int i = 0; i < files.length; ++i) {
    			System.out.println (files[i]);
                novoArq = new File(files[i].getParent() + File.separator + nomeNovoArquivo +".aar"); 
                if(novoArq.exists()) {
                	novoArq = new File(files[i].getParent() + File.separator + nomeNovoArquivo+System.currentTimeMillis() +".aar");		
                }
                
                while(!files[i].renameTo(novoArq)) {
                	System.out.println("tentando renoemar..");
                	Thread.sleep(1000);
                }
                
                novoDiretorio = UtilFile.createStringDiretorio(nomeNovoArquivo);
                FileUtils.moveFileToDirectory(novoArq, new File(pathRaiz+novoDiretorio), true);
				logger.info(
						"Classe: RenomearArq, Método:renomearArquivo, Mensagem: Arquivo renomeado com sucesso !  Caminho: "
								+ pathRaiz + novoDiretorio + novoArq.getName());
				isExiste = true;
                
            }
        } catch (IOException e) {
        	logger.error("Classe: RenomearArq, Método:renomearArquivo, Error: "+e);
		} catch (InterruptedException e) {
        	logger.error("Classe: RenomearArq, Método:renomearArquivo, Error: "+e);
		}
        return isExiste;
	}
	
	public static String getPath(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		String date = UtilDate.convertToString(data, UtilDate.PATTERN_DD_MM_YYYY_HH_MM_SS);
		String dataLigacao = date.substring(0, date.indexOf(" ")).replace(" ", " ");
		String horaLigacao = date.substring(date.indexOf(" "), date.length()-1).replace(" ", "");
		File dir = new File("Z:\\" + cal.get(Calendar.YEAR));
		dir = new File("Z:\\"+ cal.get(Calendar.YEAR) +"\\" + (cal.get(Calendar.MONTH)+1));
		dir = new File("Z:\\"+ cal.get(Calendar.YEAR) +"\\" + (cal.get(Calendar.MONTH)+1) + "\\"+ cal.get(Calendar.DAY_OF_MONTH) );
		dir = new File("Z:\\"+ cal.get(Calendar.YEAR) +"\\" + (cal.get(Calendar.MONTH)+1) + "\\"+ cal.get(Calendar.DAY_OF_MONTH) + "\\" + cal.get(Calendar.HOUR_OF_DAY) );
		dir.mkdirs();
		System.out.println(dataLigacao);
		System.out.println(horaLigacao);
		return dir.getAbsolutePath();
	}

}
