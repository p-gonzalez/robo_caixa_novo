package br.com.indra.bin;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class RenomearArq {
	
	public static void renomearArquivo(String pathOrigem, String nomeNovoArquivo, String pathDestino) {
        try {
        	File novoArq = new File(pathOrigem + File.separator + nomeNovoArquivo +".aar");
        	if(novoArq.exists()){
        		novoArq.delete();
        		System.out.println("Arquivo existe");
        		
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
                
                if(new File(pathDestino + File.separator + novoArq.getName()).exists()) {
                	System.out.println("Deletando do destino: " + new File(pathDestino + File.separator +  novoArq.getName()).getAbsolutePath());
                	new File(pathDestino + File.separator + novoArq.getName()).delete();
                }
                int tentativas = 1000;
                while(!files[i].renameTo(novoArq)) {
                	System.out.println("tentando renoemar..");
                	Thread.sleep(1000);
                }
                
                FileUtils.moveFileToDirectory(novoArq, new File(pathDestino), true);
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.HOUR_OF_DAY, 9);
		System.out.println(cal.getTime());
		System.out.println(getPath(cal.getTime()));
	}
	
	/*public static void main(String[] args) {
		System.out.println("0909909039039032_" + System.currentTimeMillis());
		//renomearArquivo("C:\\Users\\pgdesouza\\Documents\\ligacoes_dino\\", "txt", "C:\\Users\\pgdesouza\\Documents\\");
	}*/
	

}
