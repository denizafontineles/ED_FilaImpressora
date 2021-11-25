package view;
import javax.swing.JOptionPane;
import com.deniza.utils.fila.string.Fila;
import controller.ImpressoraController;

public class Main {
	public static void main(String[] args) {
		ImpressoraController iCont = new ImpressoraController();
		Fila f = new Fila();
		
		String documento = "";
		
		int opc=0;
        do{
        	StringBuffer buffer = new StringBuffer();
        	buffer.append("Fila de Impress�o\n");
        	buffer.append("O que voc� gostaria de fazer?");
        	buffer.append("\n------------------------------------------------");
        	buffer.append("\n1 - Inserir um documento na fila");
        	buffer.append("\n2 - Imprimir documentos da fila");
        	buffer.append("\n9 - Finalizar a aplica��o");
        	String opcStr = JOptionPane.showInputDialog(buffer.toString());
        	opc = Integer.parseInt(opcStr);
        	
            switch(opc){
                case 1: documento = JOptionPane.showInputDialog("Insira um documento"
                		+ " no seguinte formato:"
                		+ "\n"
                		+ "\n    ID_PC;Nome_Arquivo");
                		iCont.validaDocumento(f, documento);
                        break;
                case 2: try {
							iCont.imprime(f);
						} catch (Exception e) {
							e.printStackTrace();
						}
                        break;
                case 9: System.out.print("\n\nAplica��o Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
            }
        }
        while(opc != 9);
	}
}
