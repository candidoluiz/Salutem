package com.example.projeto;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Mascara {

   public static String formatCpf(String cpf) {
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###/##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(cpf);
        } catch (ParseException ex) {
            return  null;
        }
    }

    public static String formatCnpj(String cnpj) {
        try {
            MaskFormatter mask = new MaskFormatter("##.###.###/####");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(cnpj);
        } catch (ParseException ex) {
            return  null;
        }
    }

}
