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
        System.out.print("\nTIK TAK TOE by Diego Ruiz Piqueras");
        boolean acepta = false;
        int respuestaIntro = 0, respuestaInicio = 0, respuestaDifi = 0;
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
        boolean ganado1 = false;
        int turno = 0;
        if (respuestaIntro == 1){
            while (!acepta){
                try {
                    System.out.println();
                    System.out.print("\n1 - Dificultad Intermedia   ||     2 -  Dificultad Imposible  -->  ");
                    respuestaDifi = Integer.parseInt(teclado.nextLine());
                    if (respuestaDifi != 1 && respuestaDifi != 2){
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
                    System.out.println();
                    System.out.print("\n1 - Empieza tú    ||     2 -  Empiezas el Ordenador  -->  ");
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
            if (respuestaInicio == 1){
                tablero[1][1] = "X";
                mostrar(tablero);
                while(!comprobar(tablero) && turno < 4){
                    turno++;
                    if (respuestaDifi == 1){
                        turnoOrdenador(tablero);
                    }else{
                        turnoOrdenador(tablero);
                    }
                    mostrar(tablero);
                    if (comprobar(tablero)){
                        System.out.println("HA GANADO EL ORDENADOR");
                        ganado1 = true;
                        break;
                    }
                    turno(1,tablero, teclado);
                    mostrar(tablero);
                }
                if (turno <4 && !ganado1){
                    System.out.println("HAS GANADO");
                }else if(!ganado1){
                    System.out.println("EMPATE");
                }
            }else{
                tablero[1][1] = "O";
                mostrar(tablero);
                while(!comprobar(tablero) && turno < 4){
                    turno++;
                    turno(1,tablero, teclado);
                    mostrar(tablero);
                    if (comprobar(tablero)){
                        System.out.println("HAS GANADO");
                        ganado1 = true;
                        break;
                    }
                    if (respuestaDifi == 1){
                        turnoOrdenadorImposible(tablero);
                    }else{
                        turnoOrdenadorImposible(tablero);
                    }
                    mostrar(tablero);
                }
                if (turno <4 && !ganado1){
                    System.out.println("HA GANADO EL ORDENADOR");
                }else if(!ganado1){
                    System.out.println("EMPATE");
                }
            }
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
            }else{
                tablero[1][1] = "O";
                mostrar(tablero);
                while(!comprobar(tablero) && turno < 4){
                    turno++;
                    turno(1,tablero, teclado);
                    mostrar(tablero);
                    if (comprobar(tablero)){
                        System.out.println("HA GANADO EL JUGADOR 1");
                        ganado1 = true;
                        break;
                    }
                    turno(2,tablero, teclado);
                    mostrar(tablero);
                }
                if (turno <4 && !ganado1){
                    System.out.println("HA GANADO EL JUGADOR 2");
                }else if(!ganado1){
                    System.out.println("EMPATE");
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
        boolean acepta;
        do {
            acepta = false;
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

    public static void turnoOrdenadorImposible(String[][] tablero){
        if (tablero[0][0].equals("O") && tablero[0][1].equals("O") && tablero[0][2].equals("")){
            tablero[0][2] = "O";
        }else if (tablero[1][0].equals("O") && tablero[1][1].equals("O") && tablero[1][2].equals("")){
            tablero[1][2] = "O";
        }else if (tablero[2][0].equals("O") && tablero[2][1].equals("O") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][0].equals("O") && tablero[1][0].equals("O") && tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[0][1].equals("O") && tablero[1][1].equals("O") && tablero[2][1].equals("")){
            tablero[2][1] = "O";
        }else if (tablero[0][2].equals("O") && tablero[1][2].equals("O") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][0].equals("O") && tablero[1][1].equals("O") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][2].equals("O") && tablero[1][1].equals("O") && tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[0][0].equals("O") && tablero[0][1].equals("") && tablero[0][2].equals("O")){
            tablero[0][1] = "O";
        }else if (tablero[2][0].equals("O") && tablero[2][1].equals("") && tablero[2][2].equals("O")){
            tablero[2][1] = "O";
        }else if (tablero[0][0].equals("O") && tablero[1][0].equals("") && tablero[2][0].equals("O")){
            tablero[1][0] = "O";
        }else if (tablero[0][2].equals("O") && tablero[1][2].equals("") && tablero[2][2].equals("O")){
            tablero[1][2] = "O";
        }else if (tablero[0][0].equals("") && tablero[0][1].equals("O") && tablero[0][2].equals("O")){
            tablero[0][0] = "O";
        }else if (tablero[1][0].equals("") && tablero[1][1].equals("O") && tablero[1][2].equals("O")){
            tablero[1][0] = "O";
        }else if (tablero[2][0].equals("") && tablero[2][1].equals("O") && tablero[2][2].equals("O")){
            tablero[2][0] = "O";
        }else if (tablero[0][0].equals("") && tablero[1][0].equals("O") && tablero[2][0].equals("O")){
            tablero[0][0] = "O";
        }else if (tablero[0][1].equals("") && tablero[1][1].equals("O") && tablero[2][1].equals("O")){
            tablero[0][1] = "O";
        }else if (tablero[0][2].equals("") && tablero[1][2].equals("O") && tablero[2][2].equals("O")){
            tablero[0][2] = "O";
        }else if (tablero[0][0].equals("") && tablero[1][1].equals("O") && tablero[2][2].equals("O")){
            tablero[0][0] = "O";
        }else if (tablero[0][2].equals("") && tablero[1][1].equals("O") && tablero[2][0].equals("O")){
            tablero[0][2] = "O";
        }else if (tablero[0][0].equals("X") && tablero[0][1].equals("X") && tablero[0][2].equals("")){
            tablero[0][2] = "O";
        }else if (tablero[1][0].equals("X") && tablero[1][1].equals("X") && tablero[1][2].equals("")){
            tablero[1][2] = "O";
        }else if (tablero[2][0].equals("X") && tablero[2][1].equals("X") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][0].equals("X") && tablero[1][0].equals("X") && tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[0][1].equals("X") && tablero[1][1].equals("X") && tablero[2][1].equals("")){
            tablero[2][1] = "O";
        }else if (tablero[0][2].equals("X") && tablero[1][2].equals("X") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][0].equals("X") && tablero[1][1].equals("X") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][2].equals("X") && tablero[1][1].equals("X") && tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[0][0].equals("X") && tablero[0][1].equals("") && tablero[0][2].equals("X")){
            tablero[0][1] = "O";
        }else if (tablero[2][0].equals("X") && tablero[2][1].equals("") && tablero[2][2].equals("X")){
            tablero[2][1] = "O";
        }else if (tablero[0][0].equals("X") && tablero[1][0].equals("") && tablero[2][0].equals("X")){
            tablero[1][0] = "O";
        }else if (tablero[0][2].equals("X") && tablero[1][2].equals("") && tablero[2][2].equals("X")){
            tablero[1][2] = "O";
        }else if (tablero[0][0].equals("") && tablero[0][1].equals("X") && tablero[0][2].equals("X")){
            tablero[0][0] = "O";
        }else if (tablero[1][0].equals("") && tablero[1][1].equals("X") && tablero[1][2].equals("X")){
            tablero[1][0] = "O";
        }else if (tablero[2][0].equals("") && tablero[2][1].equals("X") && tablero[2][2].equals("X")){
            tablero[2][0] = "O";
        }else if (tablero[0][0].equals("") && tablero[1][0].equals("X") && tablero[2][0].equals("X")){
            tablero[0][0] = "O";
        }else if (tablero[0][1].equals("") && tablero[1][1].equals("X") && tablero[2][1].equals("X")){
            tablero[0][1] = "O";
        }else if (tablero[0][2].equals("") && tablero[1][2].equals("X") && tablero[2][2].equals("X")){
            tablero[0][2] = "O";
        }else if (tablero[0][0].equals("") && tablero[1][1].equals("X") && tablero[2][2].equals("X")){
            tablero[0][0] = "O";
        }else if (tablero[0][2].equals("") && tablero[1][1].equals("X") && tablero[2][0].equals("X")){
            tablero[0][2] = "O";
        }else if(tablero[1][1].equals("X") && tablero[0][2].equals("")){
            tablero[0][2] = "O";
        }else if (tablero[0][0].equals("")){
            tablero[0][0] = "O";
        }else if (tablero[0][1].equals("")){
            tablero[0][1] = "O";
        }else if (tablero[0][2].equals("")){
            tablero[0][2] = "O";
        }else if (tablero[1][0].equals("")){
            tablero[1][0] = "O";
        }else if (tablero[1][2].equals("")){
            tablero[1][2] = "O";
        }else if (tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[2][1].equals("")){
            tablero[2][1] = "O";
        }else if (tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }
    }

    public static void turnoOrdenador(String[][] tablero){
        if (tablero[0][0].equals("O") && tablero[0][1].equals("O") && tablero[0][2].equals("")){
            tablero[0][2] = "O";
        }else if (tablero[1][0].equals("O") && tablero[1][1].equals("O") && tablero[1][2].equals("")){
            tablero[1][2] = "O";
        }else if (tablero[2][0].equals("O") && tablero[2][1].equals("O") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][0].equals("O") && tablero[1][0].equals("O") && tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[0][1].equals("O") && tablero[1][1].equals("O") && tablero[2][1].equals("")){
            tablero[2][1] = "O";
        }else if (tablero[0][2].equals("O") && tablero[1][2].equals("O") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][0].equals("O") && tablero[1][1].equals("O") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][2].equals("O") && tablero[1][1].equals("O") && tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[0][0].equals("O") && tablero[0][1].equals("") && tablero[0][2].equals("O")){
            tablero[0][1] = "O";
        }else if (tablero[2][0].equals("O") && tablero[2][1].equals("") && tablero[2][2].equals("O")){
            tablero[2][1] = "O";
        }else if (tablero[0][0].equals("O") && tablero[1][0].equals("") && tablero[2][0].equals("O")){
            tablero[1][0] = "O";
        }else if (tablero[0][2].equals("O") && tablero[1][2].equals("") && tablero[2][2].equals("O")){
            tablero[1][2] = "O";
        }else if (tablero[0][0].equals("") && tablero[0][1].equals("O") && tablero[0][2].equals("O")){
            tablero[0][0] = "O";
        }else if (tablero[1][0].equals("") && tablero[1][1].equals("O") && tablero[1][2].equals("O")){
            tablero[1][0] = "O";
        }else if (tablero[2][0].equals("") && tablero[2][1].equals("O") && tablero[2][2].equals("O")){
            tablero[2][0] = "O";
        }else if (tablero[0][0].equals("") && tablero[1][0].equals("O") && tablero[2][0].equals("O")){
            tablero[0][0] = "O";
        }else if (tablero[0][1].equals("") && tablero[1][1].equals("O") && tablero[2][1].equals("O")){
            tablero[0][1] = "O";
        }else if (tablero[0][2].equals("") && tablero[1][2].equals("O") && tablero[2][2].equals("O")){
            tablero[0][2] = "O";
        }else if (tablero[0][0].equals("") && tablero[1][1].equals("O") && tablero[2][2].equals("O")){
            tablero[0][0] = "O";
        }else if (tablero[0][2].equals("") && tablero[1][1].equals("O") && tablero[2][0].equals("O")){
            tablero[0][2] = "O";
        }else if (tablero[0][0].equals("X") && tablero[0][1].equals("X") && tablero[0][2].equals("")){
            tablero[0][2] = "O";
        }else if (tablero[1][0].equals("X") && tablero[1][1].equals("X") && tablero[1][2].equals("")){
            tablero[1][2] = "O";
        }else if (tablero[2][0].equals("X") && tablero[2][1].equals("X") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][0].equals("X") && tablero[1][0].equals("X") && tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[0][1].equals("X") && tablero[1][1].equals("X") && tablero[2][1].equals("")){
            tablero[2][1] = "O";
        }else if (tablero[0][2].equals("X") && tablero[1][2].equals("X") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][0].equals("X") && tablero[1][1].equals("X") && tablero[2][2].equals("")){
            tablero[2][2] = "O";
        }else if (tablero[0][2].equals("X") && tablero[1][1].equals("X") && tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[0][0].equals("X") && tablero[0][1].equals("") && tablero[0][2].equals("X")){
            tablero[0][1] = "O";
        }else if (tablero[2][0].equals("X") && tablero[2][1].equals("") && tablero[2][2].equals("X")){
            tablero[2][1] = "O";
        }else if (tablero[0][0].equals("X") && tablero[1][0].equals("") && tablero[2][0].equals("X")){
            tablero[1][0] = "O";
        }else if (tablero[0][2].equals("X") && tablero[1][2].equals("") && tablero[2][2].equals("X")){
            tablero[1][2] = "O";
        }else if (tablero[0][0].equals("") && tablero[0][1].equals("X") && tablero[0][2].equals("X")){
            tablero[0][0] = "O";
        }else if (tablero[1][0].equals("") && tablero[1][1].equals("X") && tablero[1][2].equals("X")){
            tablero[1][0] = "O";
        }else if (tablero[2][0].equals("") && tablero[2][1].equals("X") && tablero[2][2].equals("X")){
            tablero[2][0] = "O";
        }else if (tablero[0][0].equals("") && tablero[1][0].equals("X") && tablero[2][0].equals("X")){
            tablero[0][0] = "O";
        }else if (tablero[0][1].equals("") && tablero[1][1].equals("X") && tablero[2][1].equals("X")){
            tablero[0][1] = "O";
        }else if (tablero[0][2].equals("") && tablero[1][2].equals("X") && tablero[2][2].equals("X")){
            tablero[0][2] = "O";
        }else if (tablero[0][0].equals("") && tablero[1][1].equals("X") && tablero[2][2].equals("X")){
            tablero[0][0] = "O";
        }else if (tablero[0][2].equals("") && tablero[1][1].equals("X") && tablero[2][0].equals("X")){
            tablero[0][2] = "O";
        }else if(tablero[1][1].equals("X") && tablero[2][1].equals("")){
            tablero[2][1] = "O";
        }else if(tablero[1][1].equals("X") && tablero[0][1].equals("X") && tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[0][0].equals("")){
            tablero[0][0] = "O";
        }else if (tablero[0][1].equals("")){
            tablero[0][1] = "O";
        }else if (tablero[0][2].equals("")){
            tablero[0][2] = "O";
        }else if (tablero[1][0].equals("")){
            tablero[1][0] = "O";
        }else if (tablero[1][2].equals("")){
            tablero[1][2] = "O";
        }else if (tablero[2][0].equals("")){
            tablero[2][0] = "O";
        }else if (tablero[2][1].equals("")){
            tablero[2][1] = "O";
        }else if (tablero[2][2].equals("")){
            tablero[2][2] = "O";
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

//by DIEGO RUIZ PIQUERAS in 4 hours
