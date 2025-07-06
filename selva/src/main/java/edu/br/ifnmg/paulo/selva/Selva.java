/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.br.ifnmg.paulo.selva;

import io.github.guisso.meleeinterface.Decision;
import io.github.guisso.meleeinterface.IPlayer;

/**
 *
 * @author phped
 */
public class Selva implements IPlayer {

    int cont1 = 0;
    int cont2 = 0;

    @Override
    public String getDeveloperName() {
        return "Pedro Henrique Nunes";
    }

    @Override
    public String getEngineName() {
        return "Selva";
    }

    @Override
    public Decision makeMyMove(Decision opponentPreviousMove) {
        if (opponentPreviousMove == Decision.COOPERATE) {
            this.cont1++;
        }

        if (opponentPreviousMove == Decision.DEFECT) {
            this.cont2++;
        }

        if (opponentPreviousMove == Decision.COOPERATE && cont1 >= 3) {
            this.cont1 = 0;
            return Decision.DEFECT;
        }

        if (opponentPreviousMove == Decision.DEFECT && cont2 >= 3) {
            this.cont2 = 0;
            return Decision.DEFECT;
        }

        if (cont1 == 2) {
            return Decision.DEFECT;
        }

        if (cont2 == 2) {
            return Decision.COOPERATE;
        }

        return Decision.COOPERATE;
    }
}
