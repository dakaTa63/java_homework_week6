import java.io.*;
import java.util.Random;

public class cheese {
    public static int width;
    public static int height;
    public static int mines;


    public static void main(String[] args) {
        Board.readerOne.BoardReader();
        Board mainBoard = new Board();
        mainBoard.PrintBoard();
        Board.readerTwo.BoardReaderSecondFile();

    }

    public static class Board {

        public char[][] board = new char[6][6];

        static void PrintBoard() {
            Random randomMines = new Random();

            for (int i = 0; i <= height; i++) {
                for (int j = 0; j <= width; j++) {
                    System.out.print('X');
                }
                System.out.println();
            }

            for (int x = 0; x <= height; x++) {
                for (int y = 0; y <= width; y++) {
                }
                System.out.println();
            }

            while (mines == 5) {
                height = randomMines.nextInt(height);
                width = randomMines.nextInt(width);
                if (height == 0) {
                    height = 1;
                    height++;
                }
                if (width == 0) {
                    width = 1;
                    width++;
                }
            }
        }

        public static class readerOne {

            public static void BoardReader() {
                File fileReference = new File("enemy_teritory/Enemy_teritory");
                try {
                    FileReader fileReferenceReader = new FileReader(fileReference);
                    BufferedReader reader = new BufferedReader(fileReferenceReader);

                    String lineReference;

                    while ((lineReference = reader.readLine()) != null) {
                        System.out.println(lineReference);

                        String[] Height = lineReference.split("=");
                        height = Integer.parseInt(Height[1]);

                        String[] Width = lineReference.split("=");
                        width = Integer.parseInt(Width[1]);

                        String[] Mines = lineReference.split("=");
                        mines = Integer.parseInt(Mines[1]);

                            }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static class readerTwo{

            public static void BoardReaderSecondFile(){

                File fileReferenceTwo = new File("configurations/Configurations");
                try {
                    FileReader fileReferenceTwoReader = new FileReader(fileReferenceTwo);
                    BufferedReader readerTwo = new BufferedReader(fileReferenceTwoReader);

                    String lineReferenceTwo;

                    while((lineReferenceTwo = readerTwo.readLine()) != null) {
                        System.out.println(lineReferenceTwo);
                        String[] Probes = lineReferenceTwo.split("=");
                        int probes = Integer.parseInt(Probes[1]);

                        String [] Disposal = lineReferenceTwo.split("=");
                        int disposal = Integer.parseInt(Disposal[1]);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}




