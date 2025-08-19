package br.edu.utfpr.luancoelho.warplan.entity;

import androidx.annotation.NonNull;

public enum Priority {

    LOW, MEDIUM, HIGH;

    @NonNull
    @Override
    public String toString() {
        switch (this) {
            case LOW:
                return "Baixa";
            case MEDIUM:
                return "Média";
            case HIGH:
                return "Alta";
            default:
                return "";
        }
    }

}
