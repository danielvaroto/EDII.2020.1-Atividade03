package atividade03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Atividade03 {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        var fileReader = new Scanner(new File(".\\entrada500.txt"));
        var firstLineHeader = getFirstLineHeader(fileReader);

        HashBase hash = getTipoDeSondagem(firstLineHeader.S);
        hash.create(firstLineHeader.M);

        for (var i = 0; i < firstLineHeader.N; i++) {
            if (!fileReader.hasNextLine()) {
                throw new Exception("O arquivo de entrada possui menos items que o especificado em N.");
            }

            var currentItem = fileReader.nextInt();
            hash.insert(currentItem);
        }

        System.out.println(hash.getClass().getName() + "m: " + firstLineHeader.M + " numItens: " + firstLineHeader.N + " colisions: " + hash.destroy());
    }

    private static FileHeader getFirstLineHeader(Scanner myReader) throws Exception {
        if (!myReader.hasNextLine()) {
            throw new Exception("O arquivo de entrada está vazio.");
        }

        var firstLine = myReader.nextLine();
        var firstLineData = firstLine.split(" ");

        if (firstLineData.length != 3) {
            throw new Exception("O arquivo de entrada não possui 3 valores de cabeçalho.");
        }

        var fileHeader = new FileHeader();
        fileHeader.M = Integer.parseInt(firstLineData[0]);
        fileHeader.N = Integer.parseInt(firstLineData[1]);
        fileHeader.S = Integer.parseInt(firstLineData[2]);

        return fileHeader;
    }

    private static HashBase getTipoDeSondagem(int s) throws Exception {
        switch (s) {
            case 1:
                return new SondagemLinearHash();
            
            case 2:
                return new SondagemDuplaHash();
                
            default:
                throw new Exception("Tipo de sondagem inválido.");
        }
    }
}
