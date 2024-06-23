package aplicacao;

import dados.GerenciaRobo;
import janela.JanelaRobo;

public class ACMERobots  {
    private GerenciaRobo gerenciaRobo;

    public ACMERobots(){
        gerenciaRobo = new GerenciaRobo();
    }

    public void executa() {
       new JanelaRobo(gerenciaRobo);
    }
}
