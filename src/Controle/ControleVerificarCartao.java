
package Controle;

import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControleVerificarCartao implements ActionListener{
    private final Venda venda;
    private final JPasswordField senha;
    private final JButton finalizarVenda;
    private final JButton pagamento;
    private final JFrame janela;
    
    
    public ControleVerificarCartao(Venda venda, JPasswordField senha, JButton finalizarVenda, JButton pagamento, JFrame janela){
        this.venda = venda;
        this.senha = senha;
        this.finalizarVenda = finalizarVenda;
        this.pagamento = pagamento;
        this.janela = janela;
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        janela.dispose();
        try {
        int senhaI = Integer.parseInt(senha.getText());
        if(venda.finalizarVenda(senhaI)){
            finalizarVenda.setEnabled(true);
            pagamento.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Transašao aceita");
            finalizarVenda.doClick();
        }
        else {
            JOptionPane.showMessageDialog(null, "Transašao incompleta");
        }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Somente numeros");
        }
    }
    
}
