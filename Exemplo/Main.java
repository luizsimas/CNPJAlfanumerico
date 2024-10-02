package example.test;

import br.com.luizsimas.CnpjAlfanumerico;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        System.out.println(" >> Teste de Validação de CNPJ Alfanumérico");
        System.out.println("--------------------");

        //declaração/instânciação
        CnpjAlfanumerico cnpj = new CnpjAlfanumerico();

        //Validação simples, sem validação de palavras obscenas e palavrões

        //sem máscara
        System.out.println("[Sem máscara - Numérico] Resultado para 98828361000125: " + cnpj.isCNPJ("98828361000125"));
        System.out.println("[Sem máscara - Alfanumérico] Resultado para ASDEV345FV0184: " + cnpj.isCNPJ("ASDEV345FV0184"));
        System.out.println("[Sem máscara - Alfanumérico] Resultado para DSDEV345CV0184: " + cnpj.isCNPJ("DSDEV345CV0184")); //false
        System.out.println("--------------------");

        //mascara parcial
        System.out.println("[Máscara parcial - Numérico] Resultado para 98828361/0001-25: " + cnpj.isCNPJ("98828361/0001-25"));
        System.out.println("[Máscara parcial - Alfanumérico] Resultado para ASDEV345/FV01-84: " + cnpj.isCNPJ("ASDEV345/FV01-84"));
        System.out.println("[Máscara parcial - Alfanumérico] Resultado para DSDEV345/CV01-84: " + cnpj.isCNPJ("DSDEV345/CV01-84")); //false
        System.out.println("--------------------");

        //mascarado
        System.out.println("[Com máscara - Numérico] Resultado para 98.828.361/0001-25: " + cnpj.isCNPJ("98.828.361/0001-25"));
        System.out.println("[Com máscara - Alfanumérico] Resultado para AS.DEV.345/FV01-84: " + cnpj.isCNPJ("AS.DEV.345/FV01-84"));
        System.out.println("[Com máscara - Alfanumérico] Resultado para DS.DEV.345/CV01-84: " + cnpj.isCNPJ("DS.DEV.345/CV01-84")); //false
        System.out.println("--------------------");

        //Com filtro de palavras obscenas
        System.out.println("[Com Filtro - Numérico] Resultado para 98.828.361/0001-25: " + cnpj.isCNPJ("98.828.361/0001-25",null));
        System.out.println("[Com Filtro - Alfanumérico] Resultado para AS.DEV.345/FV01-84: " + cnpj.isCNPJ("AS.DEV.345/FV01-84",null));
        System.out.println("[Com Filtro - Alfanumérico] Resultado para DS.DEV.3R5/CV01-84: " + cnpj.isCNPJ("DS.DEV.3R5/CV01-84",null));
        System.out.println("--------------------");

        //Com filtro de palavras obscenas, adicionando uma List<String> com novas palavras para análise

        //Criação da List<String>
        List<String> teste = new ArrayList<>();
        teste.add("CASA");
        teste.add("LUA");

        System.out.println("[Com Filtro e Lista adicional - Numérico] Resultado para 98.828.361/0001-25: " + cnpj.isCNPJ("98.828.361/0001-25",teste));
        System.out.println("[Com Filtro e Lista adicional - Alfanumérico] Resultado para CASAD345FV0184: " + cnpj.isCNPJ("CASAD345FV0184",teste)); //Encontrou casa, da lista adicional
        System.out.println("[Com Filtro e Lista adicional - Alfanumérico] Resultado para CA.SAD.345/FV01-84: " + cnpj.isCNPJ("CA.SAD.345/FV01-84",teste)); //Encontrou casa, da lista adicional
        System.out.println("[Com Filtro e Lista adicional - Alfanumérico] Resultado para DS.LUA.345/CV01-84: " + cnpj.isCNPJ("DS.LUA.345/CV01-84",teste)); //Encontrou lua, da lista adicional
        System.out.println("[Com Filtro e Lista adicional - Alfanumérico] Resultado para DS.LUA.345/CV01-84: " + cnpj.isCNPJ("DVPQP.345/CV01-84",teste)); //Encontrou PQP, da lista pré-definida
        System.out.println("--------------------");

    }
}