package controller;
import com.deniza.utils.fila.string.Fila;

public class ImpressoraController {
	public ImpressoraController() {
		super();
	}

	public void validaDocumento (Fila f, String documento) {
		String[] docVet = documento.split(";");
		if(docVet.length == 2) {
			insereDocumento(f, documento);
		} else {
			System.out.println("Formato incorreto <<"+documento+">>.");;
		}
	}
	
	public void insereDocumento (Fila f, String documento) {
		f.insert(documento);
	}
	
	public void imprime (Fila f) throws Exception {
		if(f.isEmpty()) {
			throw new Exception("Não há documento para ser impresso!");
		} else {
			while(!f.isEmpty()) {
				String[] documento = (f.remove()).split(";");
				int tempo = (int)((Math.random() * 1001) + 1000);  //1 a 2 segundos
				try {
					Thread.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("[#PC: "+documento[0]+" – Arquivo: "+documento[1]+"]");
			}
		}
	}
}
