package br.com.indra.UtilFile;

public class ValidarCpfCnpj {

	public static boolean verificarZerosCpfCnpj(String cpfCnpj) {
		boolean isCpfZero = false;
		if (cpfCnpj != null) {
			char digitoZero = '0';
			char[] charCpf = cpfCnpj.toCharArray();
			for (char c : charCpf) {
				if (c == digitoZero) {
					isCpfZero = true;
				} else {
					isCpfZero = false;
					break;
				}
			}
		}
		return isCpfZero;
	}
}
