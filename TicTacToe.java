import java.util.Scanner;

public class TicTacToe {
    public static void main(String[]args){
        String[][] tablero = new String[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                tablero[i][j] = "";
            }
        }
        Scanner teclado = new Scanner(System.in);
        System.out.println("TIK TAK TOE");
        System.out.print("\n1 - Un jugador    ||     2 - Dos jugadores");                                         //COMPROBACIONES
        int respuestaIntro = teclado.nextInt();
        while (respuestaIntro != 1 && respuestaIntro != 2){
            System.out.print("\n1 - Un jugador    ||     2 - Dos jugadores");                                         //COMPROBACIONES
            respuestaIntro = teclado.nextInt();
        }
        if (respuestaIntro == 1){                                         //COMPROBACIONES

        }else{
            System.out.print("\n1 - Empieza jugador 1    ||     2 -  Empieza jugador 2");                                         //COMPROBACIONES
            int respuestaInicio = teclado.nextInt();
            while (respuestaInicio != 1 && respuestaInicio != 2){
                System.out.print("\n1 - Empieza jugador 1    ||     2 -  Empieza jugador 2");                                         //COMPROBACIONES
                respuestaInicio = teclado.nextInt();
            }
            int turno = 0;
            boolean ganado1 = false;
            if (respuestaInicio == 1){
                tablero[1][1] = "X";
                while(!comprobar(tablero) && turno < 8){
                    turno++;                                            //COMPROBACIONES
                    turno(2,tablero, teclado);
                    if (comprobar(tablero)){
                        System.out.println("HA GANADO EL JUGADOR 2");
                        ganado1 = true;
                        break;
                    }
                    turno(1,tablero, teclado);
                }
                if (turno <8 && !ganado1){
                    System.out.println("HA GANADO EL JUGADOR 1");
                }else if(!ganado1){
                    System.out.println("EMPATEEE");
                }
            }else{                                                //COMPROBACIONES
                tablero[1][1] = "O";
                while(!comprobar(tablero)){                                         //COMPROBACIONES
                    turno(1,tablero, teclado);
                }
            }
        }
    }

    public static boolean comprobar(String[][] tablero) {
        if (tablero[0][0].equals("X") && tablero[0][1].equals("X") && tablero[0][2].equals("X")){
            return true;
        }else if (tablero[1][0].equals("X") && tablero[1][1].equals("X") && tablero[1][2].equals("X")){
            return true;
        }else if (tablero[2][0].equals("X") && tablero[2][1].equals("X") && tablero[2][2].equals("X")){
            return true;
        }else if (tablero[0][0].equals("X") && tablero[1][0].equals("X") && tablero[2][0].equals("X")){
            return true;
        }else if (tablero[0][1].equals("X") && tablero[1][1].equals("X") && tablero[2][1].equals("X")){
            return true;
        }else if (tablero[0][2].equals("X") && tablero[1][2].equals("X") && tablero[2][2].equals("X")){
            return true;
        }else if (tablero[0][0].equals("X") && tablero[1][1].equals("X") && tablero[2][2].equals("X")){
            return true;
        }else if (tablero[0][2].equals("X") && tablero[1][1].equals("X") && tablero[2][0].equals("X")){
            return true;
        }else if (tablero[0][0].equals("O") && tablero[0][1].equals("O") && tablero[0][2].equals("O")){
            return true;
        }else if (tablero[1][0].equals("O") && tablero[1][1].equals("O") && tablero[1][2].equals("O")){
            return true;
        }else if (tablero[2][0].equals("O") && tablero[2][1].equals("O") && tablero[2][2].equals("O")){
            return true;
        }else if (tablero[0][0].equals("O") && tablero[1][0].equals("O") && tablero[2][0].equals("O")){
            return true;
        }else if (tablero[0][1].equals("O") && tablero[1][1].equals("O") && tablero[2][1].equals("O")){
            return true;
        }else if (tablero[0][2].equals("O") && tablero[1][2].equals("O") && tablero[2][2].equals("O")){
            return true;
        }else if (tablero[0][0].equals("O") && tablero[1][1].equals("O") && tablero[2][2].equals("O")){
            return true;
        }else return tablero[0][2].equals("O") && tablero[1][1].equals("O") && tablero[2][0].equals("O");
    }

    public static void turno(int turno, String[][] tablero, Scanner teclado){
        int columna, fila;
        do {
            System.out.println("Elije una fila (0,1,2)");       //COMPROBACIONES
            fila = teclado.nextInt();
            System.out.println("Elije una columna (0,1,2)");            //COMPROBACIONES
            columna = teclado.nextInt();
        }while (!tablero[fila][columna].equals(""));
        if(turno == 1){
            tablero[fila][columna] = "X";
        }else{
            tablero[fila][columna] = "O";
        }
    }
}
