import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        String[][] tablero = new String[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                tablero[i][j] = "";
            }
        }
        Scanner teclado = new Scanner(System.in);
        System.out.print("\nTIK TAK TOE by Diego Ruiz Piqueras");
        boolean acepta = false;
        int respuestaIntro = 0, respuestaInicio = 0;
        while (!acepta){
            try {
                System.out.println();
                System.out.print("\n1 - Un jugador    ||     2 - Dos jugadores  -->  ");
                respuestaIntro = Integer.parseInt(teclado.nextLine());
                if (respuestaIntro != 1 && respuestaIntro != 2){
                    acepta = false;
                    System.out.println("Error, repítelo");
                }else{
                    acepta = true;
                }
            }catch (Exception e){
                System.out.println("Error, repítelo");
            }
        }
        acepta = false;
        if (respuestaIntro == 1){                                         //COMPROBACIONES

        }else{
            while (!acepta){
                try {
                    System.out.println();
                    System.out.print("\n1 - Empieza jugador 1    ||     2 -  Empieza jugador 2   -->  ");
                    respuestaInicio = Integer.parseInt(teclado.nextLine());
                    if (respuestaInicio != 1 && respuestaInicio != 2){
                        acepta = false;
                        System.out.println("Error, repítelo");
                    }else{
                        acepta = true;
                    }
                }catch (Exception e){
                    System.out.println("Error, repítelo");
                }
            }
            int turno = 0;
            boolean ganado1 = false;
            if (respuestaInicio == 1){
                tablero[1][1] = "X";
                mostrar(tablero);
                while(!comprobar(tablero) && turno < 4){
                    turno++;
                    turno(2,tablero, teclado);
                    mostrar(tablero);
                    if (comprobar(tablero)){
                        System.out.println("HA GANADO EL JUGADOR 2");
                        ganado1 = true;
                        break;
                    }
                    turno(1,tablero, teclado);
                    mostrar(tablero);
                }
                if (turno <4 && !ganado1){
                    System.out.println("HA GANADO EL JUGADOR 1");
                }else if(!ganado1){
                    System.out.println("EMPATE");
                }
            }else{                                                //COMPROBACIONES
                tablero[1][1] = "O";
                mostrar(tablero);
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
        int columna = -1, fila = -1;
        boolean acepta = false;
        do {
            if(turno == 1){
                System.out.println("TURNO DE: X");
            }else{
                System.out.println("TURNO DE: O");
            }
            while (!acepta){
                try {
                    System.out.println("Elije una fila (0,1,2)");
                    fila = Integer.parseInt(teclado.nextLine());
                    if (fila != 1 && fila != 2 & fila != 0){
                        acepta = false;
                        System.out.println("Error, repítelo");
                    }else{
                        acepta = true;
                    }
                }catch (Exception e){
                    System.out.println("Error, repítelo");
                }
            }
            acepta = false;
            while (!acepta){
                try {
                    System.out.println("Elije una columna (0,1,2)");
                    columna = Integer.parseInt(teclado.nextLine());
                    if (columna != 1 && columna != 2 & columna != 0){
                        acepta = false;
                        System.out.println("Error, repítelo");
                    }else{
                        acepta = true;
                    }
                }catch (Exception e){
                    System.out.println("Error, repítelo");
                }
            }
        }while (!tablero[fila][columna].equals(""));
        if(turno == 1){
            tablero[fila][columna] = "X";
        }else{
            tablero[fila][columna] = "O";
        }
    }

    public static void mostrar(String[][] tablero){
        System.out.println("\nTABLERO:");
        for (String[] i : tablero){
            for(String j : i){
                if (j.equals("")){
                    System.out.print(" - ");
                }else{
                    System.out.print(" "+j+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
